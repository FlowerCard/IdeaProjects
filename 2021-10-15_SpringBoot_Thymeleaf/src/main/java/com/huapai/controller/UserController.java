package com.huapai.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.entity.User;
import com.huapai.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/15.
 */
@Controller
@RequestMapping("/users")
@Api(value = "提供用户的登录，注册和管理接口", tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "start",value = "起始页",required = true, defaultValue = "1"),
            @ApiImplicitParam(dataType = "int", name = "limit",value = "页大小", defaultValue = "3")
    })
    @RequestMapping("/users")
    public String getUsers(Model model, Integer start, Integer limit) {
        if (start == null) {
            start = 1;
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

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Integer id, Model model) {
        User user = userService.queryById(id);
//        System.out.println(user);
        model.addAttribute("user", user);
        return "userInfo";
    }
    
    @GetMapping("/addUi")
    @ApiIgnore
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
    @ApiIgnore
    public String removeUser(Integer id) {
        userService.removeUser(id);
        return "redirect:/users/users";
    }

    @ApiOperation("单个用户查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "id",value = "用户ID",required = true)
    })
    @RequestMapping(value = "/swagger",method = RequestMethod.GET)
    @ResponseBody
    public User swagger(Integer id) {
        return userService.queryById(id);
    }

}
