package com.qf.test0831.servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/31.
 */
public class RegisterServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("注册。。。");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
