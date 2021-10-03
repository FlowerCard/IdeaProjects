package com.huapai.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huapai.pojo.User;
import com.huapai.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/2.
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {
    
    @RequestMapping("/user01")
    public String getUser01(@RequestHeader Integer token){
        System.out.println(token);
        return null;
    }
    
    @RequestMapping("/user02")
    public String getUser02(HttpServletRequest request){
        /*
            Servlet原生接收
         */
        System.out.println("----- 》 getUser");
        try {
            // 使用 request 的输入流接受请求数据
            ServletInputStream in = request.getInputStream();
            StringBuffer buffer = new StringBuffer();
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = in.read(bytes)) != -1) {
                String ret = new String(bytes,0,len);
                buffer.append(ret);
            }
            System.out.println(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping("/user03")
    public void getUser03(@RequestBody User user){
        System.out.println(user);
    }
    
    @RequestMapping("/user04")
    public void getUser04(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        
        // 使用 objectMapper 将对象转换成Json格式字符串
        String s = new ObjectMapper().writeValueAsString(user);
        
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(s);
        out.flush();
        out.close();
    }
    
    @RequestMapping("/users01")
    @ResponseBody
    public List<User> getUsers01() {
        System.out.println("AjaxController -----> userList");
        
        List<User> userList = new ArrayList<>();
        userList.add(new User(1001,"zhangsan","san",new Date()));
        userList.add(new User(1002,"lisi","si",new Date()));
        userList.add(new User(1003,"wangwu","wu",new Date()));
        userList.add(new User(1004,"qianyi","yi",new Date()));
        
        return userList;
        
    }
    
}
