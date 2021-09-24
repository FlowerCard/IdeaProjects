package com.huapai.dao;

import com.huapai.pojo.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */
public interface IUserDao {

    /**
     * 通过ID查询
     * @param id id
     * @return 用户对象
     */
    public User selectById(Integer id);

    /**
     * 通过条件查询
     * @param user 用户对象
     * @return 结果集
     */
    public List<User> selectByCondition(User user);

    /**
     * 新增用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer insertUser(User user);

    /**
     * 批量新增用户
     * @param userList 用户列表
     * @return 受影响行数
     */
    public Integer insertUserList(List<User> userList);

    /**
     * 修改用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer updateUser(User user);

    /**
     * 通过ID删除用户
     * @param id 用户ID
     * @return 受影响行数
     */
    public Integer deleteUserById(Integer id);
    
}
