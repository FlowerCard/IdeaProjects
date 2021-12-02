package com.huapai.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 */
@Component
public class MyZuulAuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * cookie ---> login_token ===> 表示已登录
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 1.拿cookie --- 拿request
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        
        // 2.拿cookie
        for (Cookie cookie : request.getCookies()) {
            if ("login_token".equals(cookie.getName())) {
                // 放行
                context.setSendZuulResponse(true);
                context.set("loginToken",cookie.getValue());
                return null;
            }
        }
        
        //不放行
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(403);
        context.setResponseBody("please do login!");
        return null;
    }
}
