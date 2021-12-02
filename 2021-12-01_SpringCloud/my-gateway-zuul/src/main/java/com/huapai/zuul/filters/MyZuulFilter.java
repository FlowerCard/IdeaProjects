package com.huapai.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 * zuul 的过滤器
 * 应用场景：限流方案：计数器限流
 */
@Component
public class MyZuulFilter extends ZuulFilter {
    
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 确定过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 相同类型的过滤器的执行顺序 0 第一个执行； 1 第二个执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否执行过滤器，如果多个过滤器，可以通过这个方法来做业务逻辑判断是否执行过滤
     * 根据业务场景判断是否执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String loginToken = (String) context.get("loginToken");
        if (StringUtils.isNotBlank(loginToken)) {
            return true;
        }
        return false;
    }

    /**
     * 执行过滤的具体逻辑代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 当前请求的上下文对象
        RequestContext context = RequestContext.getCurrentContext();

        Long count = redisTemplate.opsForValue().increment("my-zuul-count");

        if (count == 1) {
            redisTemplate.expire("my-zuul-count",60, TimeUnit.SECONDS);
        }

        if (count > 6) {
            // 限流，不放行
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(200);
            context.setResponseBody("request limited! please try again later!");
        } else {
            // 放行
            context.setSendZuulResponse(true);
        }
        return null;
    }
}
