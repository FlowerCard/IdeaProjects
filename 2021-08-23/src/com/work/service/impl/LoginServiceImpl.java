package com.work.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.work.dao.ILoginDao;
import com.work.dao.impl.LoginDaoImpl;
import com.work.pojo.User;
import com.work.service.ILoginService;
import com.work.utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class LoginServiceImpl implements ILoginService {

    private ILoginDao loginDao = new LoginDaoImpl();

    /**
     * 登录
     *
     * @param useraccount 账号
     * @param password    密码
     * @return 是否成功
     */
    @Override
    public boolean login(String useraccount, String password) {

        try {
            User user = loginDao.queryByAccount(useraccount);
            if (null == user) {
                throw new RuntimeException("账户不存在");
            }

            if (StringUtils.isEmpty(password)) {
                throw new RuntimeException("密码不能为空");
            }

            if (!password.equals(user.getPassword())) {
                throw new RuntimeException("账号或密码错误");
            }

            System.out.println(user);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 注册
     *
     * @param user 对象
     * @return 是否成功
     */
    @Override
    public boolean signUp(User user) {

        try {

            DbUtils.begin();

            List<User> users = loginDao.queryAll();
            for (User value : users) {
                if (user.getUseraccount().equals(value.getUseraccount())) {
                    throw new RuntimeException("用户存在");
                }
            }

            loginDao.insert(user);
            DbUtils.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            DbUtils.rollback();
            return false;
        }

    }
}
