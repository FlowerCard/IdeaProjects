package com.qf.test0820;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public class JdbcTest {

    String sqlDriver = "com.mysql.jdbc.Driver";

    /**
     * JDBC删除操作
     */
    @Test
    public void jdbcDeleteTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(sqlDriver);
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2105db", "root", "root");
            String sql = "delete from t_departments where DEPARTMENT_ID=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,271);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
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

    }

    /**
     * JDBC修改操作
     */
    @Test
    public void jdbcUpdateTest() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            Class.forName(sqlDriver);
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2105db", "root", "root");
            String sql = "update t_departments set MANAGER_ID=? where DEPARTMENT_ID=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,160);
            preparedStatement.setInt(2,271);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
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


    }

    /**
     * JDBC插入操作
     */
    @Test
    public void jdbcInsertTest(){

//        String sqlDriver = "com.mysql.jdbc.Driver";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(sqlDriver);
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2105db","root","root");
            String sql = "insert into t_departments (DEPARTMENT_ID, " +
                    "DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,271);
            preparedStatement.setString(2,"研发部");
            preparedStatement.setInt(3,179);
            preparedStatement.setString(4,"天堂");

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
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
    }

}
