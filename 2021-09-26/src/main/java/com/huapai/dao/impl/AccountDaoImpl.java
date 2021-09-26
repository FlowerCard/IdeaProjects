package com.huapai.dao.impl;

import com.huapai.dao.IAccountDao;
import com.huapai.pojo.Account;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
public class AccountDaoImpl implements IAccountDao {
    
    private DruidDataSource dataSource;

    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Account selectAccountById(Integer id) {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Account account = new Account();
        account.setId(id);
        account.setUsername("test01");
        account.setPassword("123123");
        account.setInfo("测试账户01");
        return account;
    }
}
