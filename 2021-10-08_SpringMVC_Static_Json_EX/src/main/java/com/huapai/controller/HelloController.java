package com.huapai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    
    @RequestMapping("/hi01")
    public String hi01(){
        System.out.println("HelloController ===> hi01");
        return "index";
    }
    
}
