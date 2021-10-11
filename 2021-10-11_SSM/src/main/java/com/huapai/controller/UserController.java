package com.huapai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.pojo.User;
import com.huapai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("users")
    public String getUserList(HttpSession session, Integer currentPage){
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage,5);

        List<User> userList = userService.queryUsers();

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        session.setAttribute("pageInfo",pageInfo);
        
        return "users";
    }
    
    @GetMapping("users/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){
        return userService.queryById(id);
    }
    
    @PostMapping("/addUser")
    public String addUser(User user){
        System.out.println("user = " + user);
        userService.addUser(user);
        
        return "redirect:/user/users";
    }
    
    @PostMapping("/modifyUser")
    public String modifyUser(User user){
        System.out.println("user = " + user);
        userService.modifyUser(user);

        return "redirect:/user/users";
    }
    
    @RequestMapping("/delete")
    public String removeUser(@RequestBody Integer id){
        userService.removeById(id);
        return "redirect:/user/users";
    }
    
}
