package com.qf.dbutils.utils;

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

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static DataSource dataSource = null;

    //静态加载数据库驱动
    static {
        try {
            //类名.class.getClassLoader().getResourceAsStream()  通过反射把资源变成流
            /*PROPERTIES.load(DbUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            Class.forName(PROPERTIES.getProperty("jdbc.driver"));*/

            PROPERTIES.load(DbUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
//            DruidDataSourceFactory.createDataSource(Properties)  创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection对象
     * @return  返回Connection对象
     * @throws SQLException 异常
     */
    public static Connection getConnection() throws SQLException {
        // 获取Connection
        Connection connection = threadLocal.get();
        if (null == connection) {
            /*connection = DriverManager.getConnection(
                    PROPERTIES.getProperty("jdbc.url"),
                    PROPERTIES.getProperty("jdbc.username"),
                    PROPERTIES.getProperty("jdbc.password")
            )*/
            connection = dataSource.getConnection();
            // 绑定Connection
            threadLocal.set(connection);
        }
        return connection;
    }

    public static DataSource getDataSource(){ return dataSource; }

    /**
     * 释放资源
     * @param resultSet     结果集
     * @param statement     SQL执行载体
     * @param connection    数据库连接对象
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
                // 解绑
                threadLocal.remove();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 公共更新
     * @param sql       需要执行的SQL
     * @param params    参数列表
     * @return          返回受影响行数
     * @throws SQLException 异常
     */
    public static int commonUpdate(String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        //如果参数列表存在
        if (null != params && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                // 设置占位符
                preparedStatement.setObject(i + 1,params[i]);
            }
        }
        int row = preparedStatement.executeUpdate();
        DbUtils.release(null,preparedStatement,null);
        //执行Update
        return row;
    }

    /**
     * 公共查询
     * @param sql       需要执行的SQL
     * @param params    参数列表
     * @return          返回结果集
     * @throws SQLException 异常
     */
    public static ResultSet commonQuery(String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        //如果参数列表存在
        if (null != params && 0 < params.length) {
            for (int i = 0; i < params.length; i++) {
                // 设置占位符
                preparedStatement.setObject(i + 1,params[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        release(null,preparedStatement,null);
        //执行Query
        return resultSet;
    }

    /**
     * 开始事务
     */
    public static void begin(){
        try {
            //自动提交取消
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务提交
     */
    public static void commit(){
        try {
            getConnection().commit();
            //事务正常提交之后需要释放资源
            release(null,null,getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     */
    public static void rollback(){
        try {
            getConnection().rollback();
            //事务回滚之后需要释放资源
            release(null,null,getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
