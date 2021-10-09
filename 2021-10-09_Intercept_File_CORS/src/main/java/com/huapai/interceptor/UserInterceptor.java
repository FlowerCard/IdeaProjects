package com.huapai.interceptor;

import jdk.management.resource.internal.ResourceNatives;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 * User模块拦截器
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("UserInterceptor ====> preHandle");
        Object loginStatus = request.getSession().getAttribute("loginStatus");
        if (null == loginStatus) {
            System.out.println("尚未登录，请重新登录");
            response.sendRedirect(request.getContextPath() + "/loginError.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("UserInterceptor ====> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("UserInterceptor ====> afterCompletion");
    }
}
