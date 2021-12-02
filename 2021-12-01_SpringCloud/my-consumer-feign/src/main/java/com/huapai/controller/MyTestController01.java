package com.huapai.controller;

import com.huapai.feign.api.TestFeignAPI;
import com.huapai.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/2.
 */
@RestController
@RequestMapping("/test01")
public class MyTestController01 {

    @Qualifier("com.huapai.feign.api.TestFeignAPI")
    @Autowired
    private TestFeignAPI testFeignAPI;

    @GetMapping("/get1")
    public String get1(Long id,String name){
        return testFeignAPI.get1(id,name);
    }
    @PostMapping("/post1")
    public String post1(@RequestBody User user){
        return testFeignAPI.post1(user);
    }
    
}
