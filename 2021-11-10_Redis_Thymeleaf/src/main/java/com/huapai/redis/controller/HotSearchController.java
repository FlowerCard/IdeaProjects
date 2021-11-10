package com.huapai.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
@Controller
@RequestMapping("/hot")
public class HotSearchController {
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @RequestMapping("/index")
    private String hosSearch(Model model) {
        redisTemplate.opsForZSet().incrementScore("hotSearch","热搜1",1);
        redisTemplate.opsForZSet().incrementScore("hotSearch","热搜2",1);
        redisTemplate.opsForZSet().incrementScore("hotSearch","热搜3",1);
        redisTemplate.opsForZSet().incrementScore("hotSearch","热搜4",1);
        redisTemplate.opsForZSet().incrementScore("hotSearch","热搜5",1);
        Set<String> set = redisTemplate.opsForZSet().reverseRange("hotSearch", 0, -1);
        System.out.println("set = " + set);
        model.addAttribute("hostSearch",set);
        return "hot-search";
    }
    
    @RequestMapping("/increment")
    private String incrementScoreHot(String hotName,Double score) {
        Double hotSearch = redisTemplate.opsForZSet().score("hotSearch", hotName);
        hotSearch += score;
        redisTemplate.opsForZSet().incrementScore("hotSearch",hotName,hotSearch);
        return "redirect:index";
    }
    
}
