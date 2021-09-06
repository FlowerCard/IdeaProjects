package com.huapai.dao;

import com.huapai.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
public interface IUserDao {

    /**
     * 删除
     * @param account 账号
     * @return 受影响行数
     * @throws SQLException SQL异常
     */
    public int deleteByAccount(String account) throws SQLException;

    /**
     * 删除
     * @param id ID
     * @return
     * @throws SQLException
     */
    public int deleteById(String id) throws SQLException;

    /**
     * 插入
     * @param user 用户
     * @return 受影响行数
     * @throws SQLException SQL异常
     */
    public int insertUser(User user) throws SQLException;

    /**
     * 更新
     * @param user 用户
     * @return 受影响行数
     * @throws SQLException SQL异常
     */
    public int updateUser(User user) throws SQLException;

    /**
     * 查单个
     * @param account 账户
     * @return 用户对象
     * @throws SQLException SQL异常
     */
    public User queryByAccount(String account) throws SQLException;

    /**
     * 查所有
     * @return 用于列表
     * @throws SQLException SQL异常
     */
    public List<User> queryAll() throws SQLException;
}
