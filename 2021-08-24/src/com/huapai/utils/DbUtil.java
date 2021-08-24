package com.huapai.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/24.
 */
public class DbUtil {

    private static final Properties PROPERTIES = new Properties();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static DataSource dataSource = null;

    static {
        try {
            PROPERTIES.load(DbUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 数据源
     * @return 返回数据源
     */
    public static DataSource getDataSource(){return dataSource;}

    /**
     * 数据库连接
     * @return  返回链接
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
     * 释放资源
     * @param resultSet 结果集
     * @param statement SQL执行载体
     * @param connection 连接
     * @throws SQLException 异常
     */
    public static void release(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
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
     * 开启事务
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
