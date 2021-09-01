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
@WebServlet("/update")
public class UpdateUser extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //设置字符集
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //获取前台数据
            String updateaccount = request.getParameter("updateaccount");
            String updatename = request.getParameter("updatename");
            String updatepassword = request.getParameter("updatepassword");
            String updateamount = request.getParameter("updateamount");

            //创建用户实例
            User user = new User();
            user.setUserAccount(updateaccount);
            user.setUsername(updatename);
            user.setPassword(updatepassword);
            user.setBalance(Double.parseDouble(updateamount));

            //反射获取JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105db", "root", "root");
            //编写SQL
            String update = "update t_login set username = ?, password = ?, balance = ? where useraccount = ?";
            //预编译SQL
            preparedStatement = connection.prepareStatement(update);
            //填写占位符
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setDouble(3,user.getBalance());
            preparedStatement.setString(4,user.getUserAccount());
            //执行SQL
            int i = preparedStatement.executeUpdate();
            //判断受影响行数
            if (0 < i) {
                response.getWriter().write("修改成功");
                return;
            }

            //修改失败
            response.getWriter().write("修改失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
                    preparedStatement.close();
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