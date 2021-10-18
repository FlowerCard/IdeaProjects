package com.huapai.controller;

import com.huapai.dao.IUserDao;
import com.huapai.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/18.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserDao userDao;
    
    @RequestMapping("/login")
    public String login(){
        System.out.println("UserController ===> login");
        return "index";
    }
    
    @RequestMapping("/getUser01")
    @ResponseBody
    public User getUser01(){
        return userDao.selectById(1);
    }
    
    @RequestMapping("/getUser02")
    @ResponseBody
    @Secured("ROLE_employee")
//    @RolesAllowed()
//    @DeclareRoles()
    public User getUser02(){
        return userDao.selectById(2);
    }
    
    @RequestMapping("/getUser03")
    @ResponseBody
    @Secured("ROLE_manager")
    public User getUser03(){
        return userDao.selectById(3);
    }
    
    @RequestMapping("/getUser04")
    @ResponseBody
    @Secured({"ROLE_employee","ROLE_manager"})
    public User getUser04(){
        return userDao.selectById(4);
    }
    
    @RequestMapping("/getUser05")
    @ResponseBody
    public User getUser05(){
        return userDao.selectById(5);
    }
    
    @RequestMapping("/getUser06")
    @ResponseBody
    public User getUser06(){
        return userDao.selectById(6);
    }
    
}
