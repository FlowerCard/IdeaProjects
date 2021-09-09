package com.huapai.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String requestURI = request.getRequestURI();
        if (requestURI.contains(".html") || (requestURI.contains(".css") ||(requestURI.contains(".js") 
                || requestURI.endsWith("/login") || requestURI.endsWith("/register") || requestURI.contains("fonts")
            || requestURI.endsWith("/validateCoide") || requestURI.endsWith("/login.jsp") || requestURI.endsWith("/register.jsp")
            || requestURI.endsWith("exist")))) {
            chain.doFilter(request,response);
            return;
        }

        Object loginUser = request.getSession().getAttribute("loginUser");
        if (null == loginUser) {
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
            return;
        }
        
        chain.doFilter(request,response);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}