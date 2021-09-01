package com.huapai.work.controller;

import com.huapai.work.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/1.
 */
@WebServlet("/user")
public class LoginController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //设置编码
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            // 获取登录的用户名密码
            String useraccount = request.getParameter("useraccount");
            String password = request.getParameter("password");

            // 反射获取JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105db", "root", "root");
            // 编写SQL
            String sql = "select id, useraccount, username, password, balance from t_login where useraccount = ?";
            // 预编译SQL
            preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            preparedStatement.setString(1,useraccount);
            // 得到执行结果
            resultSet = preparedStatement.executeQuery();
            // 实例化对象
            User user = new User();
            // 遍历结果集
            if (resultSet.next()) {
                // 获取结果集
                int id = resultSet.getInt("id");
                String account = resultSet.getString("useraccount");
                String username = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                // 赋值
                user.setId(id);
                user.setUserAccount(account);
                user.setUsername(username);
                user.setPassword(pwd);
                user.setBalance(balance);
                // 判断密码是否正确
                if (user.getPassword().equals(password)) {
                    // 登录成功
                    response.getWriter().write("登录成功");
                    return;
                }
            }
            // 登录失败
            response.getWriter().write("登录失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}