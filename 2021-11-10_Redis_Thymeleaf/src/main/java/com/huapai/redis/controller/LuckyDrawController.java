package com.huapai.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
@Controller
@RequestMapping("/lucy")
@SessionAttributes({"lucyUser"})
public class LuckyDrawController {
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @RequestMapping("/draw")
    public String lucyDraw(Model model) {
        Set<String> luckyDraw = redisTemplate.opsForSet().members("LuckyDraw");
        model.addAttribute("luckyDraw",luckyDraw);
        return "lucky-draw";
    }
    
    @RequestMapping("/add")
    public String addUserId(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        redisTemplate.opsForSet().add("LuckyDraw",userId);
        return "redirect:draw";
    }
    
    @RequestMapping("/lucyUser")
    public String getLucyUser(Model model) {
        model.addAttribute("lucyUser",redisTemplate.opsForSet().randomMember("LuckyDraw"));
        return "redirect:draw";
    }
    
}
