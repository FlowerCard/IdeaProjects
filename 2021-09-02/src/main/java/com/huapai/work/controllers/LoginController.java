package com.huapai.work.controllers;

import com.huapai.work.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //设置字符集
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //获取前台数据
            String useraccount = request.getParameter("useraccount");
            String password = request.getParameter("password");
            String inputVcode = request.getParameter("inputVcode");

            //反射加载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105db", "root", "root");
            preparedStatement = null;
            resultSet = null;

            //校验验证码
            String vcode = (String) request.getSession().getAttribute("vcode");
            if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(vcode)) {
                //查找用户
                String sql = "select id, useraccount, username, password, balance from t_login where useraccount = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,useraccount);
                resultSet = preparedStatement.executeQuery();
                User user = null;
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String account = resultSet.getString("useraccount");
                    String username = resultSet.getString("username");
                    String pwd = resultSet.getString("password");
                    double balance = resultSet.getDouble("balance");
                    user = new User(id, username, account, pwd, balance);
                    //判断密码是否正确
                    if (password.equals(user.getPassword())) {
                        //把结果存在Session
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        //跳转到登录成功页
                        response.sendRedirect(request.getContextPath() + "/login_success.html");
                    }
                }
            } else {
                //账号或用户名错误，跳回登录页
                //账户不存在
                //验证码输入错误，跳回登录页
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
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