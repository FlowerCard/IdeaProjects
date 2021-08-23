package com.qf.transfercase.service.impl;

import com.qf.transfercase.dao.IAccountDao;
import com.qf.transfercase.dao.impl.AccountDaoImpl;
import com.qf.transfercase.pojo.Account;
import com.qf.transfercase.service.IAccountService;
import com.qf.transfercase.utils.JdbcUtils;

import java.sql.SQLException;

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
            JdbcUtils.begin();

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
            accountDao.update(sourceAccount);

            // 目标账户 + 钱
            targetAccount.setAccountBalance(targetAccount.getAccountBalance() + amount);
            accountDao.update(targetAccount);

            //转账完成提交事务
            JdbcUtils.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //转账失败回滚事务
            JdbcUtils.rollback();
            return false;
        }

    }
}
