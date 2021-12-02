package com.huapai.feign.api;

import com.huapai.feign.interceptor.MyFeignInterceptor;
import com.huapai.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 */
//@FeignClient(name = "MY-USER-PROVIDER", path = "/test01")
@FeignClient(name = "MY-USER-PROVIDER", path = "/test01", configuration = MyFeignInterceptor.class)
public interface TestFeignAPI {

    @GetMapping("/show")
    public String test01(@RequestParam(value = "id") Long id);

    @GetMapping("/get1")
    public String get1(@RequestParam(value = "id") Long id,@RequestParam(value = "name") String name);

    @PostMapping("/post1")
    public String post1(@RequestBody User user);
    
}
