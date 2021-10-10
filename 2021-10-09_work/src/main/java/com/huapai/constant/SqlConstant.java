package com.huapai.constant;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
public interface SqlConstant {
    
    String SELECT_ALL_USERS = "select id, username, password, info from user";
    
    String SELECT_USER_BY_ID = "select id, username, password, info from user where id=#{id}";
    
    String INSERT_USER = "insert into user(username, password, info) VALUES (#{username},#{password},#{info})";
    
    String UPDATE_USER_BY_ID = "update user set username=#{username},password=#{password},info=#{info} where id=#{id}";
    
    String DELETE_USER_BY_ID = "delete from user where id=#{id}";
    
}
