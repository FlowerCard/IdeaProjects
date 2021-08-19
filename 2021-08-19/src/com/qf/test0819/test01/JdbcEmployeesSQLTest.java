package com.qf.test0819.test01;

import java.sql.*;

/**
 * JDBC快速入门练习
 * 查询员工表
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/19.
 */
public class JdbcEmployeesSQLTest {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.反射加载数据驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.获取链接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2105db","root","root");

            // 3.编写SQL
            String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id from t_employees";

            // 4.获取执行SQL的加载对象
            statement = connection.createStatement();

            // 5.执行SQL
            resultSet = statement.executeQuery(sql);

            // 6.处理结果
            while (resultSet.next()) {
                long employeeId = resultSet.getLong("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                Date hireDate = resultSet.getDate("hire_date");
                String jobId = resultSet.getString("job_id");
                long salary = resultSet.getLong("salary");
                double commissionPct = resultSet.getDouble("commission_pct");
                long managerId = resultSet.getLong("manager_id");
                long departmentId = resultSet.getLong("department_id");
                System.out.println(
                        employeeId + "\t\t\t" +
                        firstName + "\t\t\t" +
                        lastName + "\t\t\t" +
                        email + "\t\t\t" +
                        phoneNumber + "\t\t\t" +
                        hireDate + "\t\t\t" +
                        jobId + "\t\t\t" +
                        salary + "\t\t\t" +
                        commissionPct + "\t\t\t" +
                        managerId + "\t\t\t" +
                        departmentId + "\t\t\t"
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
