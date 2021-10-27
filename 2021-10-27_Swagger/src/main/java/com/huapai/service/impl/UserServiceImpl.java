package com.huapai.service.impl;

import com.huapai.constant.MessageConstant;
import com.huapai.constant.ResponseCode;
import com.huapai.dao.UserDao;
import com.huapai.entity.ResultVO;
import com.huapai.entity.User;
import com.huapai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/27.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    private ResultVO resultVO;


    /**
     * 查询所有用户对象
     *
     * @return 用户结果集
     */
    @Override
    public List<User> queryAll() {
        return userDao.selectAll();
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 封装User的ResultVO
     */
    @Override
    public ResultVO queryByUsername(String username) {
        User queryUser = userDao.selectByUsername(username);
        resultVO = new ResultVO();
        if (queryUser == null) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(queryUser);
        return resultVO;
    }

    /**
     * 通过ID查询用户
     *
     * @param id 用户id
     * @return 封装User的ResultVO
     */
    @Override
    public ResultVO queryById(Integer id) {
        User queryUser = userDao.selectByPrimaryKey(id);
        resultVO = new ResultVO();
        if (queryUser == null) {
            resultVO.setCode(ResponseCode.FAIL);
            resultVO.setMessage(MessageConstant.QUERY_FAIL);
            return resultVO;
        }
        resultVO.setCode(ResponseCode.SUCCESS);
        resultVO.setMessage(MessageConstant.QUERY_SUCCESS);
        resultVO.setData(queryUser);
        return resultVO;
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 是否成功
     */
    @Override
    public Boolean addUser(User user) {
        int row = userDao.insertSelective(user);
        return row != 0;
    }

    /**
     * 修改User
     *
     * @param user User对象
     * @return 是否成功
     */
    @Override
    public Boolean modifyUser(User user) {
        int row = userDao.updateByPrimaryKeySelective(user);
        return row != 0;
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 是否成功
     */
    @Override
    public Boolean removeUser(Integer id) {
        int row = userDao.deleteByPrimaryKey(id);
        return row != 0;
    }
}
