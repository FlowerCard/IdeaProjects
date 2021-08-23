package com.work.test;

import com.work.pojo.Account;
import com.work.service.IAccountService;
import com.work.service.impl.AccountServiceImpl;
import org.junit.Test;


/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class AccountTest {

    IAccountService accountService = new AccountServiceImpl();

    @Test
    public void testDelete(){
        String num = "account003";
        System.out.print("确定删除该账户吗？(Y/N)(" + num + ")：");
        System.out.println("Y");
        boolean deleteUser = accountService.deleteUser(num);
        System.out.println("假装判断用户输入 确认删除 ");
        if (deleteUser) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testUpdate(){
        String num = "account003";
        String name = "王德发";
        boolean b = accountService.updateUser(num, name);
        if (b) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testDeposit(){
        String num = "account003";
        boolean deposit = accountService.deposit(num, 5000D);
        if (deposit) {
            System.out.println("存款成功");
        } else {
            System.out.println("存款失败");
        }
    }

    @Test
    public void testInsert(){
        Account account = new Account("account003","王柳",1000D);
        if (accountService.insertUser(account)) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }

}
