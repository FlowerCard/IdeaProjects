package com.qf.java2105.huangzihao.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.IUserDao;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.User;
import com.qf.java2105.huangzihao.service.IUserService;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import com.qf.java2105.huangzihao.utils.MD5Utils;

import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public class UserServiceImpl implements IUserService {
    
    private IUserDao userDao = (IUserDao) BeanFacotry.getBean("userDao");
    
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVO<User> login(String username, String password) {
        try {
            User user = userDao.queryByUsername(username);
            if (null != user) {
                //不为空则用户存在
                if (MD5Utils.md5(password).equals(user.getPassword())) {
                    //密码正确
                    return ResultVO.ok(MessageConstant.LOGIN_SUCCESS,user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.LOGIN_FAIL);
    }

    /**
     * 搜索用户
     *
     * @param username 用户名
     * @return
     */
    @Override
    public ResultVO<List<User>> search(String username) {
        try {
            if (StringUtils.isEmpty(username)) {
                username = "%%";
            } else {
                username = "%" + username + "%";
            }
            List<User> userList = userDao.searchUser(username);
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,userList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL);
        }
    }

    /**
     * 用户ID
     *
     * @param userId 用户ID
     * @return
     */
    @Override
    public ResultVO<User> updateui(Integer userId) {
        try {
            User user = userDao.queryById(userId);
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL);
        }
    }

    /**
     * 更新用户
     *
     * @param user 用户对象
     * @return
     */
    @Override
    public ResultVO<String> update(User user) {
        try {
            JdbcUtil.begin();
            user.setUserModifieTime(new Date());
            userDao.update(user);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.UPDATE_FAIL);
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVO<String> deleteById(Integer userId) {
        try {
            JdbcUtil.begin();
            userDao.deleteById(userId);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.DELETE_FAIL);
        }
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return
     */
    @Override
    public ResultVO<String> register(User user) {
        try {
            JdbcUtil.begin();
            Integer queryDeltet = userDao.queryDeltet(user.getUsername());
            user.setUserCreateTime(new Date());
            if (queryDeltet == null) {
                userDao.inster(user);
            } else {
                user.setUserId(Long.valueOf(queryDeltet));
                userDao.updateDelete(user);
            }
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.REG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.REG_FAIL);
        }
    }

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    @Override
    public ResultVO<String> exitisName(String username) {
        try {
            Integer exitisName = userDao.exitisName(username);
            if (null != exitisName) {
                return ResultVO.error(MessageConstant.EXITIS_NAME);
            } else {
                return ResultVO.ok(MessageConstant.UNEXITIS_NAME);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.EXITIS_NAME);
        }
    }
}
