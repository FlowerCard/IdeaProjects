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
    
    @RequestMapping("/hi02")
    public String hi02(Integer num1,Integer num2){
        System.out.println("HelloController ===> num1 ====>" + num1);
        System.out.println("HelloController ===> num2 ====>" + num2);
        System.out.println(num1 / num2);
        return "index";
    }
    
    @RequestMapping("/hi03")
    public String hi03(Integer num1,Integer num2){
        System.out.println("HelloController ===> num1 ====>" + num1);
        System.out.println("HelloController ===> num2 ====>" + num2);
        try {
            System.out.println(num1 / num2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
    
}
