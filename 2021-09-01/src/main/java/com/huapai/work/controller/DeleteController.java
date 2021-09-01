package com.huapai.work.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/1.
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //设置字符集
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //获取前台数据
            String delaccount = request.getParameter("delaccount");

            //反射获取JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105db", "root", "root");
            //编写SQL
            String sql = "delete from t_login where useraccount = ?";
            //预编译SQL
            preparedStatement = connection.prepareStatement(sql);
            //设置占位符
            preparedStatement.setString(1,delaccount);
            //执行SQL
            int i = preparedStatement.executeUpdate();
            //判断受影响行数
            if (0 < i) {
                response.getWriter().write("删除成功");
                return;
            }
            response.getWriter().write("删除失败");
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