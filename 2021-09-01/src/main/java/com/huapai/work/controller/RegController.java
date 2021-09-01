package com.huapai.work.controller;

import com.huapai.work.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/1.
 */
@WebServlet("/reg")
public class RegController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //设置字符集
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //获取前台注册信息
            String useraccount = request.getParameter("useraccount");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User userIn = new User();
            userIn.setUserAccount(useraccount);
            userIn.setUsername(username);
            userIn.setPassword(password);

            //反射获取JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105db", "root", "root");
            //编写SQL
            String sql = "insert into t_login (useraccount, username, password) values (?,?,?)";
            //预编译SQL
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setString(1,userIn.getUserAccount());
            preparedStatement.setString(2,userIn.getUsername());
            preparedStatement.setString(3,userIn.getPassword());
            //返回受影响行数
            int i = preparedStatement.executeUpdate();
            //判断是否成功
            if (0 < i) {
                response.getWriter().write("注册成功");
                return;
            }
            response.getWriter().write("注册失败");
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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}