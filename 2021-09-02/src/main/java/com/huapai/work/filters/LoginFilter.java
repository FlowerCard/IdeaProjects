package com.huapai.work.filters; /**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */

import com.huapai.work.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/index.jsp") || requestURI.contains("login.html") || requestURI.contains("/css/") ||
            requestURI.contains("/validateCoide")) {
            chain.doFilter(servletRequest,servletResponse);
        } else {
            if (null != user) { // 已经登陆
                chain.doFilter(servletRequest,servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        }

    }
}
