package com.huapai.controller;

import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/21.
 */
@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录，注册和管理的接口", tags = "用户控制层")
@CrossOrigin
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "登录用户名", required = true, defaultValue = "test01"),
            @ApiImplicitParam(dataType = "string", name = "password", value = "登录密码", required = true, defaultValue = "123")
    })
    @RequestMapping("/login")
    public ResultVO<User> login(@RequestBody User user) {
        return userService.login(user.getUsername(),user.getPassword());
    }
    
}
