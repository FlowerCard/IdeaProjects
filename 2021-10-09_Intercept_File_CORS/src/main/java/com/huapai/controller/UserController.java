package com.huapai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes({"loginStatus"})
public class UserController {
    
    @RequestMapping("/login")
    public String login(Model model){
        System.out.println("UserController =====> login");
        model.addAttribute("loginStatus","true");
        return "index";
    }
    
    @RequestMapping("/main")
    public String main(Model model){
        System.out.println("UserController =====> login");
        return "index";
    }
    
}
