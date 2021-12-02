package com.huapai.feign.fallback;

import com.huapai.feign.api.TestFeignAPI;
import com.huapai.po.User;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 * feign 熔断器回调类
 */
@Component
public class MyFeignFallBack implements TestFeignAPI {
    @Override
    public String test01(Long id) {
        return "hystrix: " + id;
    }

    @Override
    public String get1(Long id, String name) {
        return "hystrix: " + id + " ----> " + name;
    }

    @Override
    public String post1(User user) {
        return "hystrix: " + user;
    }
}
