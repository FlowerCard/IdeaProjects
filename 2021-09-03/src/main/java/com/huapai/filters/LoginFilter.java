package com.huapai.filters; /**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        if (requestURI.endsWith(".html") || requestURI.endsWith("/user/login") || requestURI.endsWith("/user/register")
            || requestURI.contains("/validateCoide")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        Object loginUser = request.getSession().getAttribute("loginUser");
        if (null == loginUser) {
            response.sendRedirect(request.getContextPath() + "/pages/user/login.html");
            return;
        }
        
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
