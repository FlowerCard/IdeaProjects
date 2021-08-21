package com.qf.test0820.test02.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库工具类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public class JdbcUtils {


    /*
      静态加载数据库驱动
     */
    static {
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param connection        数据库链接
     * @param sql               执行的SQL语句
     * @param params            参数列表
     * @return                  受影响行数
     * @throws SQLException     SQL异常
     */
    public static int delete(Connection connection,String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1,params[i]);
        }
        int i = preparedStatement.executeUpdate();
        JdbcUtils.release(null,preparedStatement);
        return i;
    }

    /**
     * 更新
     * @param connection        数据库链接
     * @param sql               需要执行的SQL
     * @param params            参数列表
     * @return                  受影响行数
     * @throws SQLException     SQL异常
     */
    public static int update(Connection connection,String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1,params[i]);
        }
        int i = preparedStatement.executeUpdate();
        JdbcUtils.release(null,preparedStatement);
        return i;
    }

    /**
     * 插入
     * @param connection 获取数据库链接
     * @param sql        要执行的SQL语句
     * @param params     参数列表
     * @return           受影响行数
     * @throws SQLException SQL异常
     */
    public static int insert(Connection connection,String sql,Object ... params) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1,params[i]);
        }
        int i = preparedStatement.executeUpdate();
        JdbcUtils.release(null,preparedStatement);
        return i;
    }

    /**
     * 获取数据库连接
     * @throws SQLException SQL异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1/java2105db","root", "root");
    }


    /**
     * 释放资源，没有的资源传入 null 即可
     * @param resultSet 传入结果集
     * @param statement 传入执行载体
     * @throws SQLException SQL异常
     */
    public static void release(ResultSet resultSet, Statement statement) throws SQLException {
        if (null != resultSet) {
            resultSet.close();
        }

        if (null != statement) {
            statement.close();
        }
    }

    public static ResultSet jdbcQuery(Connection connection,String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public static ResultSet jdbcQuery(Connection connection,String sql,Object ... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1,params[i]);
        }
        return preparedStatement.executeQuery();
    }


}
