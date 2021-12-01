package com.huapai.controller;

import com.huapai.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    private final String serverName = "MY-USER-PROVIDER";
    
    @GetMapping("/id/{id}")
    public String getUseById(@PathVariable Integer id) {
        // 调用的服务 ---> 根据服务名称来调用
        String url = "http://" + serverName + "/user/id/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/username/{username}")
    public String getUserByUsername(@PathVariable String username) {
        String url = "http://" + serverName + "/user/username/" + username;
        return restTemplate.getForObject(url,String.class);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        String url = "http://" + serverName + "/user/add";
        return restTemplate.postForObject(url,user,String.class);
    }

    @PostMapping("/modify")
    public String modifyUser(@RequestBody User user) {
        String url = "http://" + serverName + "/user/modify";
        return restTemplate.postForObject(url,user,String.class);
    }

    @DeleteMapping("/delete/{id}")
    public String removeUser(@PathVariable Integer id) {
        String url = "http://" + serverName + "/user/delete/" + id;
        return restTemplate.getForObject(url,String.class);
    }
        
}
