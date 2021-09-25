package com.qf.java2105.huangzihao.filter;

import com.qf.java2105.huangzihao.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public class FrontFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User loginUser = (User) request.getSession().getAttribute("loginUser");

        if (null == loginUser) {
            response.sendRedirect(request.getContextPath() + "/front/login.jsp");
            return;
        }
        
        if (loginUser.getAdmin() == 1) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() + "/front/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}