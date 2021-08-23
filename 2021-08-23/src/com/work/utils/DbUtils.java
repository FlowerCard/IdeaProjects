package com.work.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * DbUtils练习
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class DbUtils {

    private static final Properties PROPERTIES = new Properties();

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();

    private static DataSource dataSource = null;

    static {
        try {
            PROPERTIES.load(DbUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取链接
     * @return 返回链接
     * @throws SQLException 异常
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (null == connection) {
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    /**
     * 数据源
     * @return 返回数据源
     */
    public static DataSource getDataSource(){ return dataSource; }

    /**
     * 释放资源
     * @param resultSet  结果集
     * @param statement  SQL执行载体
     * @param connection 连接
     */
    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新
     * @param sql    需要执行的SQL
     * @param params 参数列表
     * @return       返回受影响行数
     * @throws SQLException 异常
     */
    public static int commonUpdate(String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        if (null != params && 0 < params.length) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1,params[i]);
            }
        }
        int row = preparedStatement.executeUpdate();
        release(null,preparedStatement,null);
        return row;
    }

    /**
     * 查询
     * @param sql     需要执行的SQL
     * @param params  参数列表
     * @return        返回结果集
     * @throws SQLException 异常
     */
    public static ResultSet commonQuery(String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        if (null != params && 0 < params.length) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1,params[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        release(resultSet,preparedStatement,null);
        return resultSet;
    }

    /**
     * 开始事务
     */
    public static void begin(){
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public static void commit(){
        try {
            getConnection().commit();
            release(null,null,getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback(){
        try {
            getConnection().rollback();
            release(null,null,getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
