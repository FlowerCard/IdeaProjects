package com.huapai.controller;

import com.github.pagehelper.PageInfo;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/22.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/users/{page}/{limit}")
    public ResultVO getUserList(@PathVariable Integer page, @PathVariable Integer limit){
        ResultVO resultVO = new ResultVO();
        PageInfo<List<User>> pageInfo = userService.queryAll(page, limit);
        if (pageInfo == null) {
            resultVO.setCode(400);
            resultVO.setMessage("查询失败");
            return resultVO;
        }
        resultVO.setCode(200);
        resultVO.setMessage("查询成功");
        resultVO.setData(pageInfo);
        return resultVO;
    }
    
    @GetMapping("/users/{id}")
    public ResultVO<User> getUserInfo(@PathVariable Integer id) {
        User user = userService.queryById(id);
        ResultVO<User> resultVO = new ResultVO<>();
        if (user == null) {
            resultVO.setCode(400);
            resultVO.setMessage("查询失败");
            return resultVO;
        }
        resultVO.setCode(200);
        resultVO.setMessage("查询成功");
        resultVO.setData(user);
        return resultVO;
    }
    
    @PutMapping("/users")
    public Boolean modifyUser(@RequestBody User user) {
        return userService.modifyUser(user);
    }
    
    @PostMapping("/users")
    public Boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    
    @DeleteMapping("/users/{id}")
    public Boolean removeUser(@PathVariable Integer id){
        return userService.removeUser(id);
    }
    
}
