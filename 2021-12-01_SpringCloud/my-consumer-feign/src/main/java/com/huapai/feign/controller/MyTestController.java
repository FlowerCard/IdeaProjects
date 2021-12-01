package com.huapai.feign.controller;

import com.huapai.feign.api.MyTestFeign01;
import com.huapai.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@RestController
@RequestMapping("/test1")
public class MyTestController {
    
    @Autowired
    private MyTestFeign01 myTestFeign01;
    
    @GetMapping("/get1")
    public String get1(Long id, String name) {
        return myTestFeign01.get1(id, name);
    }
    
    @PostMapping("/post1")
    public String post1(@RequestBody User user) {
        return myTestFeign01.post1(user,null);
    }
    
}
