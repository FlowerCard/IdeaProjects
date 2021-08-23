package com.work.service.impl;

import com.work.dao.IAccountDao;
import com.work.dao.impl.AccountDaoImpl;
import com.work.pojo.Account;
import com.work.service.IAccountService;
import com.work.utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户业务接口实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    /**
     * 转账
     *
     * @param sourceUser 源用户
     * @param targetUser 目标用户
     * @param amount     金额
     * @return 是否成功
     */
    @Override
    public boolean transfer(String sourceUser, String targetUser, Double amount) {
        try {
            // 开启事务
            DbUtils.begin();

            // 判断源用户是否存在
            Account sourceAccount = accountDao.queryByName(sourceUser);
            // 用户不存在抛出异常
            if (null == sourceAccount.getAccountName()) {
                throw new RuntimeException("源用户不存在，请开通");
            }

            // 判断目标用户是否存在
            Account targetAccount = accountDao.queryByName(targetUser);
            // 用户不存在抛出异常
            if (null == targetAccount.getAccountName()) {
                throw new RuntimeException("目标用户不存在，请检查账户名");
            }
            // 原账户 - 钱
            sourceAccount.setAccountBalance(sourceAccount.getAccountBalance() - amount);
            int updateSource = accountDao.update(sourceAccount);

            // 目标账户 + 钱
            targetAccount.setAccountBalance(targetAccount.getAccountBalance() + amount);
            int updateTarget = accountDao.update(targetAccount);

            if (0 < updateSource && 0 < updateTarget) {
                //转账完成提交事务
                DbUtils.commit();
                return true;
            } else {
                throw new RuntimeException("转账失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //转账失败回滚事务
            DbUtils.rollback();
            return false;
        }

    }

    /**
     * 删除
     *
     * @param targetNum 需要删除的用户名
     * @return 是否成功
     */
    @Override
    public boolean deleteUser(String targetNum) {

        try {
            //开始事务
            DbUtils.begin();

            //检查用户是否存在
            Account account = accountDao.queryByNum(targetNum);

            if (null == account.getAccountNum()) {
                throw new RuntimeException("用户不存在");
            }

            int row = accountDao.deleteById(account.getAccountId());
            if (0 < row) {
                DbUtils.commit();
                return true;
            } else {
                throw new RuntimeException("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback();
            return false;
        }
    }

    /**
     * 增加
     *
     * @param account 需要增加的用户对象
     * @return 是否成功
     */
    @Override
    public boolean insertUser(Account account) {

        try {
            //开启事务
            DbUtils.begin();

            //判断用户是否存在
            List<Account> accountList = accountDao.queryAll();
            for (Account value : accountList) {
                if (value.getAccountNum().equals(account.getAccountNum())) {
                    throw new RuntimeException("账户已存在，请重新创建");
                }
            }

            int insert = accountDao.insert(account);
            if (0 < insert) {
                DbUtils.commit();
                return true;
            } else {
                throw new RuntimeException("存入失败");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback();
            return false;
        }
    }

    /**
     * 存钱
     * @param num 账户
     * @param amount 金额
     * @return 是否成功
     */
    @Override
    public boolean deposit(String num,Double amount) {

        try {
            // 开启事务
            DbUtils.begin();

            // 查询用户是否存在
            Account account = accountDao.queryByNum(num);
            if (null == account.getAccountNum()) {
                throw new RuntimeException("账户不存在，或账户错误");
            }

            account.setAccountBalance(account.getAccountBalance() + amount);
            int update = accountDao.update(account);
            if (0 < update) {
                DbUtils.commit();
                return true;
            } else {
                throw new RuntimeException("存款失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtils.rollback();
            return false;
        }
    }

    /**
     * 更新
     *
     * @param num  账户
     * @param name 名字
     * @return 是否成功
     */
    @Override
    public boolean updateUser(String num, String name) {

        try {
            // 开启事务
            DbUtils.begin();

            //查找用户是否存在
            Account account = accountDao.queryByNum(num);
            if (null == account.getAccountNum()) {
                throw new RuntimeException("账户不存在，请检查账户");
            }

            account.setAccountName(name);

            int update = accountDao.update(account);
            if (0 < update) {
                DbUtils.commit();
                return true;
            } else {
                throw new RuntimeException("更新失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            DbUtils.rollback();
            return false;
        }

    }
}
