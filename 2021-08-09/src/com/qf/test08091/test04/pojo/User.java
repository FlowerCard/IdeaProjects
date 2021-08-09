package com.qf.test08091.test04.pojo;

import com.qf.test08091.test04.AccountException;

import java.util.*;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class User {
    private String userName;
    private Integer userMoney;

    /**
     * 转账
     * @param map           传入集合
     * @param userNameout   转出账户
     * @param userNamein    转入账户
     * @param userMoney     转账金额
     */
    public void transfer(Map map,String userNameout,String userNamein,Integer userMoney) throws AccountException{
        Collection collection = map.values();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            User user = (User) it.next();
            if (user.getUserMoney() >= userMoney) {
                if (user.getUserName().equals(userNamein)) {
                    user.setUserMoney(user.getUserMoney() + userMoney);
                }
                if (user.getUserName().equals(userNameout)) {
                    user.setUserMoney(user.getUserMoney() - userMoney);
                }
            }else {
                throw new AccountException("账户余额不足");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(userMoney, user.userMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userMoney);
    }

    public User() {
    }

    public User(String userName, Integer userMoney) {
        this.userName = userName;
        this.userMoney = userMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userMoney=" + userMoney +
                '}';
    }
}
