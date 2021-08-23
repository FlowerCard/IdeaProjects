package com.qf.transfercase.test;

import com.qf.transfercase.service.IAccountService;
import com.qf.transfercase.service.impl.AccountServiceImpl;

import java.util.Scanner;

/**
 * 转账
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class Transfer {

    public static void main(String[] args) {
        IAccountService accountService = new AccountServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要转出的用户：");
        String sourceUser = scanner.next();
        System.out.print("请输入需要转入的用户：");
        String targetUser = scanner.next();
        System.out.print("请输入需要转出的金额：");
        double amount = scanner.nextDouble();

        //进行转账
        boolean transfer = accountService.transfer(sourceUser, targetUser, amount);
        if (transfer) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }


    }

}
