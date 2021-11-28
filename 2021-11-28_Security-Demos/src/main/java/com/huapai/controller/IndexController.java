package com.huapai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 */
@RestController
public class IndexController {

    @GetMapping("/admin/hello")
    public String helloAdmin() {

        return "hello, admin";
    }

    @GetMapping("/user/hello")
    public String helloUser() {

        return "hello, user";
    }

    @GetMapping("/visitor/hello")
    public String helloVisitor() {

        return "hello, visitor";
    }
    
}
