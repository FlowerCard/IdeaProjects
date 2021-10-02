package com.huapai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/1.
 */
@Controller
@RequestMapping("/jump")
public class JumpController {

    /**
     * 经过视图解析器之后生成一个新的URL
     * @return
     */
    @RequestMapping("/hi")
    public String hi(){
        System.out.println("JumpController ===> hi01");
        return "index";
    }

    /**
     * 转发到当前控制器中的其他处理器
     * @return
     */
    @RequestMapping("/forwardToHi")
    public String forwardToHi(){
        System.out.println("JumpController ===> forwardToHi");
        return "forward:hi";
    }

    /**
     * 转发到index.jsp
     * @return
     */
    @RequestMapping("/forwardToIndex")
    public String forwardToIndex(){
        System.out.println("JumpController ===> forwardToIndex");
        return "forward:/index.jsp";
    }

    /**
     * 转发到外部控制器的处理器
     * @return
     */
    @RequestMapping("/forwardToHello")
    public String forwardToHello(){
        System.out.println("JumpController ===> forwardToHello");
        return "forward:/hello/hi02";
    }

    /**
     * 重定向到内部handler
     * @return
     */
    @RequestMapping("/redirectToH01")
    public String redirectToH01(){
        System.out.println("JumpController ===> redirectToH01");
        return "redirect:/jump/hi";
    }
    
    @RequestMapping("/redirectToH02")
    public String redirectToH02(){
        System.out.println("JumpController ===> redirectToH02");
        return "redirect:hi";
    }

    /**
     * 重定向到外部的handler
     * @return
     */
    @RequestMapping("/redirectToHello")
    public String redirectToHello(){
        System.out.println("JumpController ===> redirectToHello");
        return "redirect:/hello/hi02";
    }

    /**
     * 重定向到外部的JSP
     * @return
     */
    @RequestMapping("/redirectToIndex")
    public String redirectToIndex(){
        System.out.println("JumpController ===> redirectToIndex");
        return "redirect:/index.jsp";
    }
    
}
