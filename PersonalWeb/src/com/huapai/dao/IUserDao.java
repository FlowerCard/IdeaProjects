package com.huapai.dao;

import com.huapai.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */
public interface IUserDao {

    /**
     * 删除用户
     * @param id 账户ID
     * @return 受影响行数
     */
    public int deleteById(String id) throws SQLException;

    /**
     * 更新用户
     * @param user 更新的用户信息
     * @return 受影响行数
     */
    public int update(User user) throws SQLException;

    /**
     * 插入用户
     * @param user 插入的用户信息
     * @return 受影响行数
     */
    public int insertUser(User user) throws SQLException;

    /**
     * 根据账号查询用户
     * @param account 账号
     * @return 用户对象
     */
    public User queryByAccount(String account) throws SQLException;

    /**
     * 通过ID查询
     * @param id 账号ID
     * @return
     */
    public User queryById(String id) throws SQLException;

    /**
     * 查询所有
     * @return 用户列表
     */
    public List<User> queryAll() throws SQLException;
    
    
}
