package com.huapai.feign.api;

import com.huapai.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@FeignClient(name = "MY-USER-PROVIDER", path = "test01")
public interface MyTestFeign01 {

    @GetMapping("/show")
    public String test01(Long id);

    @GetMapping("/get1")
    public String get1(Long id, String name);

    @PostMapping("/post1")
    public String post1(@RequestBody User user, @CookieValue(required = false) String token);
    
}
