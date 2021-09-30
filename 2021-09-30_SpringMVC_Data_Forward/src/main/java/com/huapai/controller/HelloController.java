package com.huapai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/30.
 */
@Controller // IOC控制层
/**
 * 请求路径
 * 模块名字和 url-pattern 中的效果相同
 */
@RequestMapping("/hello")
public class HelloController {

    /**
     * 模块中的一个handler
     * @return
     */
    @RequestMapping("/hi01")
    public String getHi01(){
        System.out.println("HelloController ===> hi01");
        return "/hi01.jsp";
    }

    /**
     * 使用视图解析器进行跳转
     * @return 跳转的字符串
     */
    @RequestMapping("/hi02")
    public String getHi02(){
        System.out.println("HelloController ===> hi02");
        // 使用视图解析器进行的跳转
        return "hi02";
    }
    
}
