package com.huapai.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    
    @Resource
    private IUserService userService;
    
    @GetMapping("/users")
    @ResponseBody
    public ResultVO getUsers(Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<User> userList = userService.queryAll();
        ResultVO resultVO = new ResultVO();
        if (userList.size() != 0) {
            PageInfo<User> pageInfo = new PageInfo<>(userList);
            resultVO.setData(pageInfo.getList());
            resultVO.setCount((int) pageInfo.getTotal());
            resultVO.setCode(0);
        }
        return resultVO;
    }
    
    @GetMapping("/users/{username}")
    @ResponseBody
    public Boolean existUser(@PathVariable String username){
        return userService.existUser(username);
    }
    
    @RequestMapping("users/{id}")
    @ResponseBody
    public User searchUser(@PathVariable Integer id){
        return userService.queryById(id);
    }
    
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return "redirect:login.jsp";
        }
        ResultVO resultVO = userService.login(username, password);
        if (resultVO.getCode() == 0) {
            session.setAttribute("userInfo",resultVO.getData());
            return "redirect:/index.jsp";
        }
        return "redirect:login.jsp";
    }
    
    @RequestMapping("/register")
    public String register(User user){
        if (user == null) {
            return "redirect:register.jsp";
        }
        Boolean register = userService.register(user);
        if (register) {
            return "redirect:login.jsp";
        }
        return "redirect:register.jsp";
    }
    
    @RequestMapping("/modifyUser")
    public String modifyUser(User user, HttpSession session){
        userService.modifyUser(user);
        User userInfo = (User) session.getAttribute("userInfo");
        
        if (user.getPassword().equals(userInfo.getPassword())) {
            return "redirect:/users/userList.jsp";
        } else {
            //ID相同判断为同一个用户
            if (user.getId().equals(userInfo.getId())) {
                session.invalidate();
                return "redirect:login.jsp";
            }
            return "redirect:/users/userList.jsp";
        }
        
    }
    
    @DeleteMapping("users/{id}")
    @ResponseBody
    public ResultVO removeUser(@PathVariable Integer id){
        Boolean flag = userService.removeUser(id);
        ResultVO resultVO = new ResultVO();
        if (flag) {
            resultVO.setCode(0);
        } else {
            resultVO.setCode(1);
        }
        return resultVO;
    }
    
    @RequestMapping("/signOut")
    public String signOut(HttpSession session){
        session.invalidate();
        return "redirect:login.jsp";
    }
    
}
