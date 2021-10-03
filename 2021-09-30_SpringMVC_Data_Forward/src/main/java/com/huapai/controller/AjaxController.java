package com.huapai.controller;

import com.huapai.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
    
}
