package com.huapai.service.impl;

import com.huapai.dao.IUserDao;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 用户业务层接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    
    @Resource
    private IUserDao userDao;
    private ResultVO resultVO;
    
    /**
     * 查询所有
     *
     * @return 用户集合
     */
    @Override
    public List<User> queryAll() {
        return userDao.selectAll();
    }

    /**
     * 用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    @Override
    public Boolean existUser(String username) {
        User user = userDao.selectByUsernameUser(username);
        return user == null;
    }

    @Override
    public User queryById(Integer id) {
        return userDao.selectById(id);
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    @Override
    public ResultVO login(String username, String password) {
        resultVO = new ResultVO();
        resultVO.setCode(1);
        User user = userDao.selectByUsernameUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                resultVO.setCode(0);
                resultVO.setData(user);
            }
        }
        return resultVO;
    }

    /**
     * 注册
     *
     * @param user 用户对象
     * @return 结构
     */
    @Override
    public Boolean register(User user) {
        Integer isDelete = userDao.selectIsDelete(user.getUsername());
        if (isDelete != null) {
            user.setId(isDelete);
            user.setIsAdmin(0);
            user.setIsDelete(0);
            userDao.updateIsDelete(user);
            return true;
        } else {
            userDao.insertUser(user);
            return true;
        }
    }

    @Override
    public Boolean modifyUser(User user) {
        Integer row = userDao.updateUser(user);
        return row != 0;
    }

    @Override
    public Boolean removeUser(Integer id) {
        Integer row = userDao.setIsDelete(id);
        return row != 0;
    }
}
