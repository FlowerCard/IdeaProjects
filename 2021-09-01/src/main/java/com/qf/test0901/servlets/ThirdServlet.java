package com.qf.test0901.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/1.
 */
@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println("获取请求方式：" + method);

        String head = request.getHeader("host");
        System.out.println("通过请求头名称获得：" + head);

        String contextPath = request.getContextPath();
        System.out.println("获取项目路径：" + contextPath);

        String requestURI = request.getRequestURI();
        System.out.println("获取请求URI：" + requestURI);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println("获取请求URL：" + requestURL);

        String username = request.getParameter("username");
        System.out.println("通过请求名称获得对应的值：" + username);

        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("获得所有请求名称，枚举类型");
        while (parameterNames.hasMoreElements()) {
            String nextElement = parameterNames.nextElement();
            System.out.println(nextElement);
        }

        String[] hobbies = request.getParameterValues("hobbies");
        System.out.println("根据请求名称获得参数值列表" + Arrays.asList(hobbies));

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("获得所有请求参数对应的Map集合");
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey() + " : " + stringEntry.getValue());
        }

        ServletContext servletContext = request.getServletContext();
        System.out.println("获得servletContext对象：" + servletContext);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}