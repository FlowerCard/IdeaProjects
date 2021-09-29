package com.huapai.dao;

import com.huapai.pojo.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

public interface IAccountDao {

    /**
     * 通过名字搜索账户
     * @param account  用户名
     * @return  用户对象
     */
    @Select("select id, useraccount, username, password, balance, idcode, create_time, modified_time, status, isdelete from t_account where useraccount=#{useraccount}")
    Account selectAccountByAccount(String account);

    /**
     * 更新用户
     * @param account 被更新的用户对象
     * @return 受影响行数
     */
    @Update("update t_account set balance=#{balance} where id=#{id}")
    Integer updateAccount(Account account);
    
}