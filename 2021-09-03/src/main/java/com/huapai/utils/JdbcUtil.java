package com.huapai.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
 */
public class JdbcUtil {

    private static final Properties PROPERTIES = new Properties();

    private static DataSource dataSource = null;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            //反射加载数据库配置文件
            PROPERTIES.load(JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            //加载Druid连接池配置
            dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     * @return 返回数据源
     */
    public static DataSource getDataSource() {return dataSource;}

    /**
     * 获取链接
     * @return 返回链接
     * @throws SQLException 异常
     */
    public static Connection getConnection() throws SQLException {
        //线程绑定获取Connection
        Connection connection = threadLocal.get();
        if (null == connection) {
            connection = dataSource.getConnection();
            //把connection绑定到threadlocal中
            threadLocal.set(connection);
        }
        return connection;
    }

    /**
     * 释放资源
     * @param resultSet 结果集
     * @param statement SQL运行载体
     * @param connection 数据库链接
     * @throws SQLException SQL异常
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (null != resultSet) {
            resultSet.close();
        }
        if (null != statement) {
            statement.close();
        }
        if (null != connection) {
            connection.close();
        }
    }

    /**
     * 通用更新
     * @param sql       SQL语句
     * @param params    参数
     * @return          返回受影响行数
     * @throws SQLException SQL异常
     */
    public static int commonUpdate(String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        if (null != params && 0 < params.length) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
        }
        int row = preparedStatement.executeUpdate();
        release(null,preparedStatement,null);
        return row;
    }

    /**
     * 通用查询
     * @param sql       执行的SQL
     * @param params    参数列表
     * @return          返回结果集
     * @throws SQLException SQL异常
     */
    public static ResultSet commonQuery(String sql, Object ... params) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        if (null != params && 0 < params.length) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
        }
        ResultSet executeQuery = preparedStatement.executeQuery();
        release(executeQuery,preparedStatement,null);
        return executeQuery;
    }

    /**
     * 事务开始
     */
    public static void begin() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务提交
     */
    public static void commit() {
        try {
            getConnection().commit();
            release(null,null,getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     */
    public static void rollback() {
        try {
            getConnection().rollback();
            release(null,null,getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
