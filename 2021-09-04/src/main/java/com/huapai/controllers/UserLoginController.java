package com.huapai.controllers;

import com.huapai.common.ResultVO;
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
@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {

    private static final long serialVersionUID = 9069119225983102724L;
    private IUserServices userServices = new UserServicesImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useraccount = request.getParameter("useraccount");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");

        ResultVO resultVO = ResultVO.fail("验证码错误");

        String vCode = (String) request.getSession().getAttribute("vCode");

        if ((null != inputVcode || "".equals(inputVcode.trim())) && inputVcode.equalsIgnoreCase(vCode)) {
            resultVO = userServices.login(useraccount,password);
        }

        PrintWriter writer = response.getWriter();
        if (resultVO.getSuccess()) {
            User data = (User) resultVO.getData();
            request.getSession().setAttribute("loginUser",data);
            writer.write(
                    "<h1>" + data.getUsername() + "，登录成功</h1>" +
                            "<a href='" + request.getContextPath() + "/pages/user/login.html>返回</a>"
            );
        } else {
            writer.write(
                    "<h1>" + resultVO.getMessage() + "</h1>" +
                            "<a href='" + request.getContextPath() + "/pages/user/login.html>返回</a>"
            );
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}