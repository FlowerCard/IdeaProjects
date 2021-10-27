package com.huapai.controller;

import com.huapai.constant.MessageConstant;
import com.huapai.constant.ResponseCode;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/27.
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户控制器", tags = "用户模块", description = "用户接口")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    private ResultVO resultVO = null;
    

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/users")
    @ApiOperation("用户列表接口")
    public ResultVO getUsers() {
        List<User> userList = userService.queryAll();
        resultVO = new ResultVO();
        if (userList.size() == 0) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            return resultVO;
        }
        
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(userList);
        return resultVO;
    }
    
    @GetMapping("/{id}")
    @ApiOperation("ID查询用户")
    @ApiImplicitParam(dataType = "int", name = "id", value = "用户Id", required = true, example = "1")
    public ResultVO getUserById(@PathVariable Integer id) {
        return userService.queryById(id);
    }
    
    @GetMapping("/{username}")
    @ApiOperation("Username查询用户")
    @ApiImplicitParam(dataType = "string", name = "username", value = "用户名", required = true, example = "test01")
    public ResultVO getUserByUsername(@PathVariable String username) {
        return userService.queryByUsername(username);
    }
    
    @PostMapping("/user")
    @ApiOperation("新增用户接口")
    public ResultVO addUser(User user) {
        Boolean flag = userService.addUser(user);
        resultVO = new ResultVO();
        if (flag) {
            resultVO.setCode(ResponseCode.SUCCESS);
            
        } else {
            resultVO.setCode(ResponseCode.FAIL);
        }
        return resultVO;
    }
    
    @PutMapping("/user")
    @ApiOperation("修改用户")
    public ResultVO modifyUser(User user) {
        Boolean flag = userService.modifyUser(user);
        resultVO = new ResultVO();
        if (flag) {
            resultVO.setCode(ResponseCode.SUCCESS);

        } else {
            resultVO.setCode(ResponseCode.FAIL);
        }
        return resultVO;
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("ID删除用户")
    @ApiImplicitParam(dataType = "int", name = "id", value = "用户ID", required = true)
    public ResultVO removeUser(@PathVariable Integer id) {
        Boolean flag = userService.removeUser(id);
        resultVO = new ResultVO();
        if (flag) {
            resultVO.setCode(ResponseCode.SUCCESS);

        } else {
            resultVO.setCode(ResponseCode.FAIL);
        }
        return resultVO;
    }
    
}
