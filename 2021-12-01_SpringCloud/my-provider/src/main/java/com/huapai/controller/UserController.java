package com.huapai.controller;

import com.alibaba.fastjson.JSON;
import com.huapai.po.User;
import com.huapai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable Integer id) {
        return JSON.toJSONString(userService.getUserById(id));
    }
    
    @GetMapping("/username/{username}")
    public String getUserByUsername(@PathVariable String username) {
        return JSON.toJSONString(userService.getUserByUsername(username));
    }
    
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        Boolean flag = userService.addUser(user);
        if (flag) {
            return "添加成功";
        }
        return "添加失败";
    }
    
    @PostMapping("/modify")
    public String modifyUser(@RequestBody User user) {
        Boolean flag = userService.modifyUser(user);
        if (flag) {
            return "修改成功";
        }
        return "修改失败";
    }
    
    @DeleteMapping("/delete/{id}")
    public String removeUser(@PathVariable Integer id) {
        Boolean flag = userService.removeUser(id);
        if (flag) {
            return "删除成功";
        }
        return "删除失败";
    }
    
}
