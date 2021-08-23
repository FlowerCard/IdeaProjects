package com.qf.transfercase.dao;

import com.qf.transfercase.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户dao
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public interface IAccountDao {

    /**
     * 通过ID删除
     * @param id    需要删除的ID对应数据
     * @return      返回受影响行数
     * @throws SQLException 异常
     */
    public int deleteById(Long id) throws SQLException;

    /**
     * 更新
     * @param account   需要更新的对象
     * @return          返回受影响行数
     * @throws SQLException 异常
     */
    public int update(Account account) throws SQLException;

    /**
     * 插入
     * @param account 需要插入的对象
     * @return        受影响行数
     * @throws SQLException 异常
     */
    public int insert(Account account) throws SQLException;

    /**
     * 查询对应ID的数据
     * @param id    需要查询的ID
     * @return      返回对象
     * @throws SQLException 异常
     */
    public Account queryById(Long id) throws SQLException;

    /**
     * 查询用户名对应的数学
     * @param name  需要查询的用户名
     * @return      返回对象
     * @throws SQLException 异常
     */
    public Account queryByName(String name) throws SQLException;

    /**
     * 查询所有数据
     * @return  返回结果集列表
     * @throws SQLException 异常
     */
    public List<Account> queryAll() throws SQLException;

}
