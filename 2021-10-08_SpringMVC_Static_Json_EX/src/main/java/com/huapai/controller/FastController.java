package com.huapai.controller;

import com.huapai.pojo.Hero;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 */
@RestController
@RequestMapping("/fast")
public class FastController {
    
    @RequestMapping("/fast01")
    public Hero fast01(){
        return new Hero(1001,"hero01","hero01",new Date(),123.789);
    }
    
    @RequestMapping("/fast02")
    public String fast02(@RequestBody Hero hero){
        System.out.println("hero ----> " + hero);
        return "success";
    }
    
}
