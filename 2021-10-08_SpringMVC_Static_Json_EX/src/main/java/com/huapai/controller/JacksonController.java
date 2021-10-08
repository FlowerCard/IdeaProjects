package com.huapai.controller;

import com.huapai.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 */
@RequestMapping("/jack")
@RestController
public class JacksonController {
    
    @RequestMapping("/jack01")
    public User jack01(){
        return new User(1001,"test01","123",new Date(),100.1234);
    }
    
    @RequestMapping("/jack02")
    public String jack02(@RequestBody User user){
        System.out.println("user ----> " + user);
        return "success";
    }
    
}
