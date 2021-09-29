package com.huapai.service.impl;

import com.huapai.dao.IAccountDao;
import com.huapai.pojo.Account;
import com.huapai.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户业务层接口实现类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/29.
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
    
    @Autowired
    private IAccountDao accountDao;
    
    /**
     * 转账
     *
     * @param fromName 转出账户
     * @param toName   转入账户
     * @param amount   金额
     * @return         受影响行数
     */
    @Override
    public Integer transfer(String fromName, String toName, Double amount) {
        if (amount <=0) {
            throw new RuntimeException("转账金额不正确...");
        }

        Account fromAccount = accountDao.selectAccountByAccount(fromName);
        if (null == fromAccount) {
            throw new RuntimeException("转出账户不存在...");
        }

        Account toAccount = accountDao.selectAccountByAccount(toName);
        if (null == toAccount) {
            throw new RuntimeException("转入账户不存在...");
        }

        if (fromAccount.getBalance() - amount < 0) {
            throw new RuntimeException("账户余额不足...");
        }
        
        //转出
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        Integer fromRet = accountDao.updateAccount(fromAccount);

//        System.out.println(10/0);

        //转入
        toAccount.setBalance(toAccount.getBalance() + amount);
        Integer toRet = accountDao.updateAccount(toAccount);

        if (fromRet == 0 || toRet == 0) {
            throw new RuntimeException("转账失败...");
        }
        
        Integer ret = fromRet = toRet;

        return ret;
    }
}
