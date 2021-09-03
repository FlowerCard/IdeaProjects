package com.huapai.dao;

import com.huapai.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
 */
public interface IUserDao {

    /**
     * 根据用户账号删除
     * @param delAccount 需要被删除的账号
     * @return  返回受影响行数
     */
    public int deleteByAccount(String delAccount) throws SQLException;

    /**
     * 修改用户
     * @param user 需要修改的用户信息
     * @return 返回受影响行数
     */
    public int modifyUser(User user) throws SQLException;

    /**
     * 插入用户
     * @param user 需要插入的用户
     * @return 返回受影响行数
     */
    public int insertUser(User user) throws SQLException;

    /**
     * 通过账户查用户
     * @param account 账户
     * @return 返回用户对象
     */
    public User queryByAccount(String account) throws SQLException;

    /**
     * 查询所有用户
     * @return 返回用户列表
     */
    public List<User> queryAll() throws SQLException;

}
