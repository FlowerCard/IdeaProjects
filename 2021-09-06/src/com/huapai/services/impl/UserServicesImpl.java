package com.huapai.services.impl;

import com.huapai.common.ResultVO;
import com.huapai.constant.UserIsDeleteConstant;
import com.huapai.constant.UserMessageConstant;
import com.huapai.constant.UserStatusConstant;
import com.huapai.dao.IUserDao;
import com.huapai.dao.impl.UserDaoImpl;
import com.huapai.pojo.User;
import com.huapai.services.IUserServices;
import com.huapai.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
public class UserServicesImpl implements IUserServices {
    
    private IUserDao userDao = new UserDaoImpl();
    
    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    @Override
    public ResultVO login(String account, String password) {
        ResultVO resultVO = ResultVO.fail("服务器忙，请稍后重试");
        try {
            User user = userDao.queryByAccount(account);
            
            //判断用户是否存在
            if (null == user) {
                resultVO = ResultVO.fail(UserMessageConstant.UNKNOWN_USER);
            } else {
                //判断用户是否删除
                if (user.getIsdelete().intValue() == UserIsDeleteConstant.MARK_DELETED_USER) {
                    resultVO = ResultVO.fail(UserMessageConstant.MARK_DELETED_USER);
                } else {
                    //判断密码
                    if (null == password || "".equals(password)) {
                        resultVO = ResultVO.fail(UserMessageConstant.LOGIN_FAIL);
                    } else {
                        //判断用户状态
                        if (user.getStatus().intValue() == UserStatusConstant.INACTIVE_USERS) {
                            resultVO = ResultVO.fail(UserMessageConstant.INACTIVE_USER);
                        } else if (user.getStatus().intValue() == UserStatusConstant.LOGGED_OUT_USERS) {
                            resultVO = ResultVO.fail(UserMessageConstant.LOGGED_OUT_USER);
                        } else if (user.getStatus().intValue() == UserStatusConstant.LOCKS_PER_USER) {
                            resultVO = ResultVO.fail(UserMessageConstant.LOCKS_PRE_USER);
                        } else if (user.getStatus().intValue() == UserStatusConstant.EXPIRED_USER) {
                            resultVO = ResultVO.fail(UserMessageConstant.EXPIRED_USER);
                        } else {
                            //登录成功，发送消息，附带数据
                            resultVO = ResultVO.ok(UserMessageConstant.LOGIN_SUCCES,user);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return
     */
    @Override
    public Boolean resgister(User user) {
        try {
            JdbcUtil.begin();
            int row = userDao.insertUser(user);
            if (0 < row) {
                JdbcUtil.commit();
                return true;
            } else {
                JdbcUtil.rollback();
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 用户列表
     *
     * @return
     */
    @Override
    public ResultVO userList() {
        ResultVO resultVO = ResultVO.fail("服务器忙，请稍后重试");
        try {
            List<User> users = userDao.queryAll();
            
            resultVO = ResultVO.ok("查询成功",users);
            return resultVO;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    /**
     * 通过ID删除用户
     *
     * @return
     */
    @Override
    public ResultVO removeUserById(String id) {
        ResultVO resultVO = ResultVO.fail("删除失败");
        try {
            
            JdbcUtil.commit();
            int row = userDao.deleteById(id);
            if (0 < row) {
                resultVO = ResultVO.ok("删除成功");
                JdbcUtil.commit();
            } else {
                resultVO = ResultVO.fail("删除失败");
                JdbcUtil.rollback();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
        }
        return resultVO;
    }
}
