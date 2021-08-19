package com.qf.test0819.test01;

import java.sql.*;

/**
 * JDBC快速入门练习
 * 查询地区表
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/19.
 */
public class JdbcLocationsSQLTest {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.反射获取数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.创建连接
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java2105db","root","root");

            // 3.编写SQL
            String sql = "select location_id, street_address, postal_code, city, state_province, country_id from t_locations";

            // 4.获取执行SQL的载体
            statement = connection.createStatement();

            // 5.执行SQL
            resultSet = statement.executeQuery(sql);

            // 6.处理结果
            while (resultSet.next()) {
                String locationId = resultSet.getString("location_id");
                String streetAddress = resultSet.getString("street_address");
                String postalCode = resultSet.getString("postal_code");
                String city = resultSet.getString("city");
                String stateProvince = resultSet.getString("state_province");
                String countryId = resultSet.getString("country_id");
                System.out.println(
                        locationId + "\t\t\t" +
                        streetAddress + "\t\t\t" +
                        postalCode + "\t\t\t" +
                        city + "\t\t\t" +
                        stateProvince + "\t\t\t" +
                        countryId + "\t\t\t"
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
