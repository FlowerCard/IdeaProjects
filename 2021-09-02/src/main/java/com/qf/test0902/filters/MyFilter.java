package com.qf.test0902.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(".......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取参数
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        if (!username.isEmpty() && !password.isEmpty()) {
            //不为空就跳转
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        System.out.println("没有跳转");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
