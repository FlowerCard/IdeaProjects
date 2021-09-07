package com.huapai.controllers.user;

import com.huapai.pojo.User;
import com.huapai.services.IUserServices;
import com.huapai.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
@WebServlet("/user/register")
public class UserRegisterController extends HttpServlet {

    private static final long serialVersionUID = 3294361267395421145L;
    private IUserServices userServices = new UserServicesImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useraccount = request.getParameter("useraccount");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User regUser = new User();
        regUser.setUseraccount(useraccount);
        regUser.setUsername(username);
        regUser.setPassword(password);

        Boolean resgister = userServices.resgister(regUser);
        PrintWriter writer = response.getWriter();

        if (resgister) {
            writer.write(
                    "<h1>注册成功</h1>"
                            + "<a href = '" + request.getContextPath() + "/pages/user/login.jsp'>返回</a>"
            );
        } else {
            writer.write(
                    "<h1>用户已存在</h1>"
                            + "<a href = '" + request.getContextPath() + "/pages/user/register.jsp'>返回</a>"
            );
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}