package com.huapai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.entity.User;
import com.huapai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/15.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String getUsers(Model model, Integer start, Integer limit) {
        if (start == null) {
            start = 0;
        }
        if (limit == null) {
            limit = 3;
        }
        PageHelper.startPage(start, limit);
        List<User> userList = userService.queryAll();
        PageInfo pageInfo = new PageInfo(userList);
        model.addAttribute("userList", pageInfo);
        return "userList";
    }

    @RequestMapping("/users/{id}")
    public String getUser(@PathVariable Integer id, Model model) {
        User user = userService.queryById(id);
//        System.out.println(user);
        model.addAttribute("user", user);
        return "userInfo";
    }
    
    @RequestMapping("/addUi")
    public String addUi(){
        return "userAdd";
    }
    
    @RequestMapping("/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users/users";
    }

    @RequestMapping("/modify")
    public String modifyUser(User user) {
        userService.modifyUser(user);
        return "redirect:/users/users";
    }

    @RequestMapping("/remove")
    public String removeUser(Integer id) {
        userService.removeUser(id);
        return "redirect:/users/users";
    }

}
