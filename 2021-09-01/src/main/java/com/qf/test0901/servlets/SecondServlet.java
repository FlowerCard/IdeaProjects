package com.qf.test0901.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/1.
 */
public class SecondServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("SecondServlet");

        //获得servlet初始化参数
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        System.out.println("username : " + username);
        System.out.println("password : " + password);

        //获得servlet名字
        String servletName = servletConfig.getServletName();
        System.out.println("servletName = " + servletName);

        //获得所有初始化参数名称，枚举对象
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String parameter = servletConfig.getInitParameter(name);
            System.out.println(name + " : " + parameter);
        }

        //获得servletContext对象：代表整个web应用对象，在内存中只存在一份
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("servletContext = " + servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
