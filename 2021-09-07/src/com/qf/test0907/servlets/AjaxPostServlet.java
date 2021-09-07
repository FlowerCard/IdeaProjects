package com.qf.test0907.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/7.
 */
@WebServlet("/ajaxpages/ajaxpost")
public class AjaxPostServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        int intGender = Integer.parseInt(gender);
        if (intGender == 1) {
            response.getWriter().write("欢迎" + username + "，您的性别为男");
        } else if (intGender == 0) {
            response.getWriter().write("欢迎" + username + "，您的性别为女");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}