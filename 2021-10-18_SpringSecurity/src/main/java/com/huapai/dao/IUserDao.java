package com.huapai.dao;

import com.huapai.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/18.
 */
@Repository("userDao")
public interface IUserDao {

    /**
     * 通过名字来查
     * @param username 用户名
     * @return 用户对象
     */
    public User selectByUsername(String username);

    /**
     * 通过ID插查询
     * @param id 用户id
     * @return 用户对象
     */
    public User selectById(Integer id);
    
}
