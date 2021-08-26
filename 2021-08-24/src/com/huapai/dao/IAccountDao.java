package com.huapai.dao;

import com.huapai.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/24.
 */
public interface IAccountDao {

    /**
     * 查询所有
     * @return  返回对象结果列表
     * @throws SQLException 异常
     */
    public List<Account> queryAll() throws SQLException;

    /**
     * 通过用户Num查询
     * @param accountNum 用户num
     * @return  返回用户对象
     * @throws SQLException 异常
     */
    public Account queryByNum(String accountNum) throws SQLException;

    /**
     * 插入
     * @param account 用户对象
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    public int insert(Account account) throws SQLException;

    /**
     * 更新
     * @param account 用户对象
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    public int update(Account account) throws SQLException;

    /**
     * 删除
     * @param accountId 用户Id
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    public int deleteById(String accountId) throws SQLException;


}
