package com.huapai.dao;

import com.huapai.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/21.
 */
@Repository("userDao")
public interface IUserDao {

    /**
     * 查询所有用户
     * @return 用户集合
     */
    List<User> selectAll();

    /**
     * 通过id查询用户
     * @param id 用户id
     * @return 用户对象
     */
    User selectById(Integer id);

    /**
     * 通过username查询用户
     * @param username 用户名
     * @return 用户对象
     */
    User selectByUsername(String username);
    
}
