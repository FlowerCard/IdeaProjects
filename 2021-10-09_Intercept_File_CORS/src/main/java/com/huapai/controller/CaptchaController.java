package com.huapai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Controller
@RequestMapping("/cap")
public class CaptchaController {
    
    @RequestMapping("/check")
    public String check(String code, HttpSession session){
        String captcha = (String) session.getAttribute("captcha");
        if (captcha.equalsIgnoreCase(code)) {
            return "index";
        }
        return "loginError";
    }
    
}
