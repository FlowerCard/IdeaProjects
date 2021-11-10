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
        Set<String> set = redisTemplate.opsForZSet().reverseRange("hotSearch", 0, -1);
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
