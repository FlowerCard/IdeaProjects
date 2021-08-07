package com.qf.test07;

public class NetUser {
    private String userId;
    private long userPassWord;
    private String emailAddress;

    /**
     * 用户信息
     * @param userId        用户ID
     * @param userPassWord  用户密码
     */
    public NetUser(String userId,long userPassWord){
        this.userId = userId;
        this.userPassWord = userPassWord;
        this.emailAddress = userId + "@gameschool.com";
    }

    public NetUser(String userId,long userPassWord,String emailAddress){
        this.userId = userId;
        this.userPassWord = userPassWord;
        this.emailAddress = emailAddress;
    }

    public void display(){
        System.out.println("用户信息：" + this.userId + "," + "邮箱:" + this.emailAddress);
    }

}
