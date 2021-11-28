package com.huapai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 */
@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "一起学习Security吧";
    }
    
}
