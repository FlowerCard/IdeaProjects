package com.qf.java2105.huangzihao.dao;

import com.qf.java2105.huangzihao.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户持久层
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public interface IUserDao {

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return
     */
    public User queryByUsername(String username) throws SQLException;

    /**
     * 搜索用户列表
     * @param username 用户名
     * @return
     */
    public List<User> searchUser(String username) throws SQLException;

    /**
     * 通过ID查询用户
     * @param userId 用户ID
     * @return
     */
    public User queryById(Integer userId) throws SQLException;

    /**
     * 更新用户
     * @param user 用户对象
     */
    public void update(User user) throws SQLException;

    /**
     * 更新用户名删除状态
     * @param user
     */
    public void updateDelete(User user) throws SQLException;

    /**
     * 查询账号是否产出
     * @param username 用户名
     * @return
     */
    public Integer queryDeltet(String username) throws SQLException;

    /**
     * 删除用户
     * @param userId 用户id
     */
    public void deleteById(Integer userId) throws SQLException;

    /**
     * 新增用户
     * @param user 用户对象
     */
    public void inster(User user) throws SQLException;

    /**
     * 用户名是否存在
     * @param username 用户名
     * @return
     */
    public Integer exitisName(String username) throws SQLException;
    
}
