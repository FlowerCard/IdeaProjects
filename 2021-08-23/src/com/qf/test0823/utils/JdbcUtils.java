package com.qf.test0823.utils;

import java.sql.*;
import java.util.Properties;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class JdbcUtils {

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(JdbcUtils.class.getResourceAsStream("jdbc.properties"));
            Class.forName(PROPERTIES.getProperty("jdbc.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到数据库连接对象
     * @return  返回数据库连接
     * @throws SQLException SQL异常
     */
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(
                PROPERTIES.getProperty("jdbc.url"),
                PROPERTIES.getProperty("jdbc.username"),
                PROPERTIES.getProperty("jdbc.password")
        );
    }

    /**
     * 释放资源
     * @param resultSet 结果集
     * @param statement SQL载体
     * @param connection 连接对象
     */
    public static void release(ResultSet resultSet, Statement statement,Connection connection) {
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

    public static int queryAll(){
        return 0;
    }

}
