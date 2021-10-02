package com.huapai.controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/2.
 */
@Controller
@RequestMapping("/data")
@SessionAttributes({"username"})
public class DataController {
    
    @RequestMapping("/modify")
    public String modifyData(Integer num, HttpServletRequest request){
        num += 66;
        System.out.println("num ===> " + num);
        request.setAttribute("num",num);
        return "data01";
    }
    
    @RequestMapping("/modify02")
    public String modifyData02(Integer num, HttpServletRequest request){
        num += 66;
        System.out.println("num ===> " + num);
        request.setAttribute("num",num);
        return "redirect:/data01.jsp";
    }
    
    @RequestMapping("/update01")
    public String updateData01(Integer num, String username, HttpSession session, HttpServletRequest request){
        num += 66;
        username = username + num;
        System.out.println("num ===> " + num);
        request.setAttribute("num",num);
        session.setAttribute("username",username);
        return "data02";
    }
    
    @RequestMapping("/update02")
    public String updateData02(Integer num, String username, HttpSession session, HttpServletRequest request){
        num += 66;
        username = username + num;
        System.out.println("num ===> " + num);
        request.setAttribute("num",num);
        session.setAttribute("username",username);
        return "redirect:/data02.jsp";
    }
    
    @RequestMapping("/changeModel01")
    public String changeModel01(Model model,Integer num,String username){
        num += 66;
        username = username + num;
        System.out.println("num ===> " + num);
        System.out.println("username ===> " + username);
        model.addAttribute("num",num);
        model.addAttribute("username",username);
        return "data03";
    }
    
    @RequestMapping("/changeModel02")
    public String changeModel02(Model model,Integer num,String username){
        num += 66;
        username = username + num;
        System.out.println("num ===> " + num);
        System.out.println("username ===> " + username);
        model.addAttribute("num",num);
        model.addAttribute("username",username);
        return "redirect:/data03.jsp";
    }
    
    @RequestMapping("changeModelAndView01")
    public ModelAndView changeModelAndView01(Integer num, String username) {
        ModelAndView modelAndView = new ModelAndView();
        num += 100;
        username += num;
        
        //存入数据
        modelAndView.addObject("num",num);
        modelAndView.addObject("username",username);
        
        //设置视图
        modelAndView.setViewName("data04");
        
        return modelAndView;
    }
    
    @RequestMapping("changeModelAndView02")
    public ModelAndView changeModelAndView02(Integer num, String username) {
        // 模型和视图对象 —— 既能存数据，又能存视图
        ModelAndView modelAndView = new ModelAndView();
        num += 100;
        username += num;
        
        //存入数据
        modelAndView.addObject("num",num);
        modelAndView.addObject("username",username);
        
        //设置视图
        modelAndView.setViewName("redirect:/data04.jsp");
        
        return modelAndView;
    }
    
}
