package com.huapai.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 */
public class MyFeignInterceptor implements RequestInterceptor {

    /**
     * 获取这一次 feign 要发送的 request 对象，然后进行包装
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 1.从当前请求对象中获取 cookie
        // 1.1 获取当前请求
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 1.2 获取 cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                // 2.把 token 的 cookie 封装到要发送的 request 请求对象(requestTemplate)的请求头中
                requestTemplate.header(HttpHeaders.COOKIE,"token=" + cookie.getValue());
                return;
            }
        }
    }
}
