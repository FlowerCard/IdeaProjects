package com.huapai.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.huapai.common.ResultVO;
import com.huapai.constant.UserMessageConstant;
import com.huapai.dao.IUserDao;
import com.huapai.dao.impl.UserDaoImpl;
import com.huapai.pojo.User;
import com.huapai.service.IUserService;
import com.huapai.utils.JdbcUtil;

import java.sql.SQLException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */
public class UserServiceImpl implements IUserService {
    
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
        ResultVO resultVO = ResultVO.fail(UserMessageConstant.LOGIN_FAIL);
        User user = null;
        try {
            user = userDao.queryByAccount(account);
            if (null != user) {
                if (!StringUtils.isEmpty(password)) {
                    if (password.equals(user.getPassword())) {
                        resultVO = ResultVO.ok("登录成功",user);
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
     * @param user 注册用户
     * @return
     */
    @Override
    public ResultVO register(User user) {
        ResultVO resultVO = ResultVO.fail(UserMessageConstant.REGISTER_FAIL);
        try {
            JdbcUtil.begin();
            User account = userDao.queryByAccount(user.getUseraccount());
            if (null == account) {
                int row = userDao.insertUser(user);
                if (0 < row) {
                    resultVO = ResultVO.ok(UserMessageConstant.RESGISTER_SUCCESS);
                    JdbcUtil.commit();
                } else {
                    JdbcUtil.rollback();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    /**
     * 检查用户
     *
     * @param id 用户账号
     * @return
     */
    @Override
    public ResultVO checkUser(String id) {
        ResultVO resultVO = ResultVO.fail(UserMessageConstant.REGISTER_FAIL);
        try {
            User user = userDao.queryById(id);
            if (null != user && !StringUtils.isEmpty(id)) {
//                if ()
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultVO;
    }
}
