package com.qf.test08091.test04;

import com.qf.test08091.test04.pojo.User;

import java.util.*;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class TransferAccount {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        User user = new User();
        userMap.put(0,new User("Tom",1000));
        userMap.put(1,new User("Lucy",1000));

        user.transfer(userMap,"Tom","Lucy",500);

        System.out.println(userMap);

    }
}
