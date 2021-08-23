package com.qf.transfercase.test;

import com.qf.transfercase.dao.IAccountDao;
import com.qf.transfercase.dao.impl.AccountDaoImpl;
import com.qf.transfercase.pojo.Account;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class JdbcUtilsTest {

    @Test
    public void testQuery(){
        IAccountDao accountDao = new AccountDaoImpl();
        try {
            List<Account> accountList = accountDao.queryAll();
            accountList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
