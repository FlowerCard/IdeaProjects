package com.huapai.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */

public class JdbcUtil {

    private static final Properties PROPERTIES = new Properties();

    private static DataSource dataSource = null;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            PROPERTIES.load(JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        //1.获取connection
        Connection connection = threadLocal.get();
        if (null == connection) {
            connection = dataSource.getConnection();
            //绑定
            threadLocal.set(connection);
        }
        System.out.println(connection);
        return connection;
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (null != resultSet) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != statement) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != connection) {
                //解绑
                threadLocal.remove();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启事务
     */
    public static void begin() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public static void commit() {
        try {
            getConnection().commit();
            JdbcUtil.release(null, null, getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback() {
        try {
            getConnection().rollback();
            JdbcUtil.release(null, null, getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
