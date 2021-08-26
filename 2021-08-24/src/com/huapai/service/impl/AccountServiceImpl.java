package com.huapai.service.impl;

import com.huapai.dao.IAccountDao;
import com.huapai.dao.impl.AccountDaoImpl;
import com.huapai.pojo.Account;
import com.huapai.service.IAccountService;
import com.huapai.utils.DbUtil;

import java.sql.SQLException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/24.
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    /**
     * 转账
     *
     * @param sourceUserNum 源账户
     * @param targetUserNum 目标账户
     * @param amount     金额
     * @return 是否成功
     */
    @Override
    public boolean transfer(String sourceUserNum, String targetUserNum, Double amount) {

        try {
            DbUtil.begin();
            Account sourceAccount = accountDao.queryByNum(sourceUserNum);
            if (null == sourceAccount) {
                throw new RuntimeException("源账户不存在，请开通");
            }
            Account targetAccount = accountDao.queryByNum(targetUserNum);
            if (null == targetAccount) {
                throw new RuntimeException("目标账户不存在，请核对目标账户账号");
            }
            if (sourceAccount.getBalance() < amount) {
                throw new RuntimeException("源账户金额不足");
            }
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);
            accountDao.update(sourceAccount);
            accountDao.update(targetAccount);
            DbUtil.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtil.rollback();
            return false;
        }

    }

    /**
     * 存款
     *
     * @param accountNum 账户Num
     * @param amount     金额
     * @return 是否成功
     */
    @Override
    public boolean deposit(String accountNum, Double amount) {
        try {
            DbUtil.begin();
            Account account = accountDao.queryByNum(accountNum);
            if (null == account) {
                throw new RuntimeException("账户不存在");
            }
            account.setBalance(account.getBalance() + amount);
            accountDao.update(account);
            DbUtil.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            DbUtil.rollback();
            return false;
        }
    }

    /**
     * 取款
     *
     * @param accountNum 账户Num
     * @param amount     金额
     * @return 是否成功
     */
    @Override
    public boolean withdrawal(String accountNum, Double amount) {
        return false;
    }

    /**
     * 创建用户
     *
     * @param account 用户对象
     * @return 是否成功
     */
    @Override
    public boolean createUser(Account account) {
        return false;
    }

    /**
     * 删除用户
     *
     * @param accountNum 用户Num
     * @return 是否成功
     */
    @Override
    public boolean deleteUser(String accountNum) {
        return false;
    }
}
