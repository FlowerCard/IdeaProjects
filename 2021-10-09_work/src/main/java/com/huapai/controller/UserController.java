package com.huapai.controller;

import com.alibaba.fastjson.JSONObject;
import com.huapai.pojo.User;
import com.huapai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.searchAllUsers();
    }
    
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        System.out.println(id);
        return userService.searchUserById(id);
    }
    
    @PostMapping("/users")
    public Integer addUser(@RequestBody User user){
        System.out.println("addUser ===> user ===> " + user);
        return userService.addUser(user);
    }
    
    @PutMapping("/users")
    public Integer modifyUser(@RequestBody User user){
        System.out.println("modify ====> user ====> " + user);
        return userService.modifyUser(user);
    }
    
    @DeleteMapping("/users/{id}")
    public Integer removeUser(@PathVariable Integer id){
        System.out.println("removeUse ====> id ====> " + id);
        return userService.removeUser(id);
    }
    
}
