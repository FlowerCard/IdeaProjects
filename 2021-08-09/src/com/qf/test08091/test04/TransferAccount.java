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
        userMap.put(1,new User("Tom",1000));
        userMap.put(2,new User("Lucy",1000));

        Collection set = userMap.values();
        Iterator it = set.iterator();
        while (it.hasNext()) {

        }

    }
}
