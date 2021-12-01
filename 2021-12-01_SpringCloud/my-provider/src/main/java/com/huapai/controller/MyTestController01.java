package com.huapai.controller;

import com.huapai.po.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@RestController
@RequestMapping("/test01")
public class MyTestController01 {
    
    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping("/show")
    public String test01(Long id) {
        return String.format("hello %d, from %s",id,serverPort);
    }

    @GetMapping("/get1")
    public String get1(Long id, String name) {
        return String.format("id: %d, name: %s",id,name);
    }

    @PostMapping("/post1")
    public String post1(@RequestBody User user, @CookieValue(required = false) String token) {
        return String.format("id: %d, username: %s, token: %s", user.getId(), user.getUsername(), token);
    }
    
}
