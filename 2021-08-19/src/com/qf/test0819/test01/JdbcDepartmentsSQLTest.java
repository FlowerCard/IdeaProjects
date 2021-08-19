package com.qf.test0819.test01;

import java.sql.*;

/**
 * JDBC快速入门练习
 * 查询部门表
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/19.
 */
public class JdbcDepartmentsSQLTest {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.反射获取数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.获取链接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2105db","root","root");

            // 3.编写SQL语句
            String sql = "select department_id, department_name, manager_id, location_id from t_departments";

            // 4.获取执行SQL的载体对象
            statement = connection.createStatement();

            // 5.执行SQL
            resultSet = statement.executeQuery(sql);

            // 6.处理结果
            while (resultSet.next()) {
                long departmentId = resultSet.getLong("department_id");
                String departmentName = resultSet.getString("department_name");
                long managerId = resultSet.getLong("manager_id");
                String locationId = resultSet.getString("location_id");
                System.out.println(
                        departmentId + "\t\t\t" +
                        departmentName + "\t\t\t" +
                        managerId + "\t\t\t" +
                        locationId + "\t\t\t"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.释放资源，先开后关
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
