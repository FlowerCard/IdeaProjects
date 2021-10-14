package com.huapai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/13.
 */
@WebFilter("/*")
public class SourceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        if (requestURI.endsWith(".html") || requestURI.endsWith(".css") || requestURI.endsWith(".js")
            || requestURI.endsWith("/login") || requestURI.endsWith("/register") || requestURI.endsWith("/login.jsp")
                 || requestURI.endsWith("/register.jsp") || requestURI.contains("/img/")
        ) {
            filterChain.doFilter(request,response);
            return;
        }

        Object userInfo = request.getSession().getAttribute("userInfo");
        if (null == userInfo) {
            response.sendRedirect(request.getContextPath() + "/users/login.jsp");
            return;
        }
        
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
