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

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
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

        ResultVO resultVO = ResultVO.fail("网络繁忙，请稍后重试");

        try {
            JdbcUtil.begin();

            //根据用户账号判断用户是否存在
            User loginUser = userDao.queryByAccount(account);

            //判断用户是否为空
            if (null == loginUser) {
                resultVO = ResultVO.fail(UserMessageConstant.UNKNOWN_USER);
            }

            if (loginUser.getIsdelete().intValue() == UserIsDeleteConstant.MARK_DELETED_USER) {
                resultVO = ResultVO.fail(UserMessageConstant.UNKNOWN_USER);
            } else {
                if (!loginUser.getPassword().equals(password)) {
                    //判断密码
                    resultVO = ResultVO.fail("用户名或密码错误");
                } else {
                    //0:未激活 1:已激活 2:注销 3:锁定 4:过期
                    //判断用户状态
                    if (loginUser.getStatus().intValue() == UserStatusConstant.INACTIVE_USERS) {
                        resultVO = ResultVO.fail(UserMessageConstant.INACTIVE_USERS);
                    } else if (loginUser.getStatus().intValue() == UserStatusConstant.LOGGED_OUT_USERS) {
                        resultVO = ResultVO.fail(UserMessageConstant.LOGGED_OUT_USERS);
                    } else if (loginUser.getStatus().intValue() == UserStatusConstant.LOCKS_PER_USER) {
                        resultVO = ResultVO.fail(UserMessageConstant.LOCKS_PER_USER);
                    } else if (loginUser.getStatus().intValue() == UserStatusConstant.EXPIRED_USER) {
                        resultVO = ResultVO.fail(UserMessageConstant.EXPIRED_USER);
                    } else {
                        //登录成功
                        resultVO = ResultVO.ok("登录成功",loginUser);
                    }
                }
            }
            JdbcUtil.commit();
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
        }


        return resultVO;
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return 受影响行数
     */
    @Override
    public Boolean register(User user) {
        try {
            JdbcUtil.begin();
            int row = userDao.insertUser(user);
            if (1 == row) {
                JdbcUtil.commit();
                return true;
            } else if (0 == row) {
                JdbcUtil.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtil.rollback();
        }
        return false;
    }
}
