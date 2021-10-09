package com.huapai.controller;

import com.huapai.pojo.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = {"http://10.31.161.31:8080","http://localhost:8080","http://127.0.0.1:8080"})
public class HeroController {
    
    @PostMapping("/hero")
    public Hero addHero(@RequestBody Hero hero){
        Integer num = new Random().nextInt(100);
        hero.setId(num);
        hero.setUsername(hero.getUsername() + num);
        return hero;
    }
    
    @DeleteMapping("/hero/{id}")
    public Integer deleteHero(@PathVariable Integer id){
        return id;
    }
    
    @PutMapping("/hero")
    public Hero modifyHero(@RequestBody Hero hero){
        hero.setInfo("修改后的Hero" + new Date());
        return hero;
    }
    
    @GetMapping("/hero/{id}")
    public Integer getHero(@PathVariable Integer id, HttpServletRequest request,HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Credentials","true");
        
        String info = (String) request.getSession().getAttribute("info");

        System.out.println("getHero ====> info ===> " + info);
        
        id = id + new Random().nextInt(100);
        return id;
    }
    
    @GetMapping("/heroes")
    public List<Hero> getHeroes(HttpServletResponse response, HttpServletRequest request){
        
        response.setHeader("Access-Control-Allow-Credentials","true");
        
        Hero hero01 = new Hero(1001,"张三","测试01","法外狂徒");
        Hero hero02 = new Hero(1002,"李四","测试02","张三的朋友");
        
        request.getSession().setAttribute("info","getHeroes设置了info");
        System.out.println(request.getSession().getAttribute("info"));

        return Arrays.asList(hero01,hero02);
    }
    
}
