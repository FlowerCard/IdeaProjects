package com.huapai.dao;

import com.huapai.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 用户持久层接口
 */
@Repository("userDao")
public interface IUserDao {

    /**
     * 查询所有
     * @return 用户集合
     */
    public List<User> selectAll();

    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 用户对象
     */
    public User selectByUsernameUser(String username);

    /**
     * 查询已删除的用户
     * @param username 用户名
     * @return ID
     */
    public Integer selectIsDelete(String username);

    /**
     * 更新已删除的用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer updateIsDelete(User user);

    /**
     * 通过用户ID查询
     * @param id 用户ID
     * @return 用户对象
     */
    public User selectById(Integer id);

    /**
     * 插入用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer insertUser(User user);

    /**
     * 更新用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer updateUser(User user);

    /**
     * 设置删除状态
     * @param id 被删除的ID
     */
    public Integer setIsDelete(Integer id);
    
}
