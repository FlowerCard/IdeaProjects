package com.huapai.dao;

import com.huapai.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/11.
 */
@Repository("userDao")
public interface IUserDao {

    /**
     * 查询所有用户
     * @return 用户集合
     */
    public List<User> selectAll();

    /**
     * 通过ID查询用户
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
     * 根据ID删除
     * @param id 用户ID
     * @return 受影响行数
     */
    public Integer deleteById(Integer id);
    
}
