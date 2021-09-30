package com.huapai.controller;

import com.huapai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/30.
 * 收参
 *      要名词对应
 *      传来参数的 name 属性和控制器的方法形参名字一样
 *      可接受八种基本类型和String参数
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    
    @RequestMapping("/p01")
    public String getParam01(){
        System.out.println("ParamController ====> getParam01");
        return "index";
    }
    
    @RequestMapping("/p02")
    public String getParam02(Integer num){
        System.out.println("ParamController ====> getParam02 ====> num ====> " + num);
        return "index";
    }
    
    @RequestMapping("/p03")
    public String getParam03(Integer num, String username){
        System.out.println("ParamController ====> getParam03 ====> num ====> " + num);
        System.out.println("ParamController ====> getParam03 ====> username ====> " + username);
        return "index";
    }
    
    @RequestMapping("/p04")
    public String getParam04(Integer num, String username,String password){
        System.out.println("ParamController ====> getParam04 ====> num ====> " + num);
        System.out.println("ParamController ====> getParam04 ====> username ====> " + username);
        System.out.println("ParamController ====> getParam04 ====> password ====> " + password);
        return "index";
    }
    
    @RequestMapping("/p05")
    public String getParam05(Integer num, String username, Date birth){
        System.out.println("ParamController ====> getParam04 ====> num ====> " + num);
        System.out.println("ParamController ====> getParam04 ====> username ====> " + username);
        System.out.println("ParamController ====> getParam04 ====> birth ====> " + birth);
        return "index";
    }
    
    @RequestMapping("/p06")
    public String getParam06(User user){
        System.out.println("ParamController ====> getParam04 ====> user ====> " + user);
        return "index";
    }
    
}
