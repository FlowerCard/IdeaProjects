package com.qf.test0902.cookietest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */
@WebServlet("/testCookie1")
public class TestCookie01Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Cookie
        Cookie cookie = new Cookie("cookieName","cookieValue");

        // 设置Cookie的存活时间，单位：秒
        cookie.setMaxAge(30);

        // 把cookie放到响应头
        response.addCookie(cookie);

        // 给客户端响应
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}