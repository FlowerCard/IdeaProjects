package com.huapai.controller;

import com.huapai.pojo.User;
import com.huapai.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
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
        System.out.println("ParamController ====> getParam05 ====> num ====> " + num);
        System.out.println("ParamController ====> getParam05 ====> username ====> " + username);
        System.out.println("ParamController ====> getParam05 ====> birth ====> " + birth);
        return "index";
    }
    
    @RequestMapping("/p06")
    public String getParam06(User user){
        System.out.println("ParamController ====> getParam06 ====> user ====> " + user);
        return "index";
    }
    
    @RequestMapping("/p07")
    public String getParam07(String[] hobby){
        System.out.println("ParamController ====> getParam07 ====> arr ====> " + Arrays.toString(hobby));
        return "index";
    }

    /**
     * 集合收参
     *  http://localhost:8080/day59/param/p08?users[0].id=10010&users[0].username=zhangsan
     * @param users 对象集合
     * @return
     */
    @RequestMapping("/p08")
    public String getParam08(Users users){
        System.out.println("ParamController ====> getParam08 ====> users ====> " + users);
        return "index";
    }

    /**
     * 路径收参
     * @return
     */
    @RequestMapping("/p09/{id}")
    public String getParam09(@PathVariable Integer id){
        System.out.println("ParamController ====> getParam09 ====> id ====> " + id);
        return "index";
    }
    
    @RequestMapping("/p10/{id}")
    public String getParam10(@PathVariable("id") Integer uid){
        System.out.println("ParamController ====> getParam10 ====> uid ====> " + uid);
        return "index";
    }
    
    @RequestMapping("/p11/{id}/{username}/{password}")
    public String getParam11(@PathVariable Integer id,@PathVariable String username,@PathVariable String password){
        System.out.println("ParamController ====> getParam11 ====> id ====> " + id);
        System.out.println("ParamController ====> getParam11 ====> username ====> " + username);
        System.out.println("ParamController ====> getParam11 ====> password ====> " + password);
        return "index";
    }
    
}
