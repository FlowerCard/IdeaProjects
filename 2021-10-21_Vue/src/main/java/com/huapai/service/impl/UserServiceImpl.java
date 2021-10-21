package com.huapai.service.impl;

import com.huapai.dao.IUserDao;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/21.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao userDao;
    
    @Override
    public ResultVO<List<User>> queryAllUsers() {
        List<User> userList = userDao.selectAll();
        ResultVO<List<User>> resultVO = new ResultVO<>();
        if (userList.size() == 0){
            resultVO.setCode(204);
            resultVO.setMessage("请求收到，但返回信息为空");
        }
        
        resultVO.setCode(200);
        resultVO.setMessage("携带数据返回");
        resultVO.setData(userList);
        
        return resultVO;
    }

    @Override
    public ResultVO<User> login(String username, String password) {
        ResultVO<User> resultVO = new ResultVO<>();
        if (username == null || password == null) {
            resultVO.setCode(400);
            resultVO.setMessage("参数存在问题，请检查");
            return resultVO;
        }
        
        User loginUser = userDao.selectByUsername(username);
        if (loginUser == null) {
            resultVO.setCode(204);
            resultVO.setMessage("用户不存在");
            return resultVO;
        }

        if (!loginUser.getPassword().equals(password)) {
            resultVO.setCode(400);
            resultVO.setMessage("用户名密码错误，请检查");
            return resultVO;
        }
        
        resultVO.setCode(200);
        resultVO.setMessage("登录成功");
        resultVO.setData(loginUser);
        return resultVO;
    }
}
