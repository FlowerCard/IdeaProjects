package com.huapai.controller;

import com.huapai.pojo.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = {"http://10.31.161.31:8080","http://localhost:8080","http://127.0.0.1:8080"})
public class HeroController {
    
    @GetMapping("/heroes")
    public List<Hero> getHeroes(HttpServletResponse response){
        
        response.setHeader("Access-Control-Allow-Credentials","true");
        
        Hero hero01 = new Hero(1001,"张三","测试01","法外狂徒");
        Hero hero02 = new Hero(1002,"李四","测试02","张三的朋友");

        return Arrays.asList(hero01,hero02);
    }
    
}
