package com.huapai.dao;

import com.huapai.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
public interface IUserDao {

    /**
     * 通过id查询
     * @param userId
     * @return
     */
    User selectById(@Param("userId") Integer userId);

    /**
     * 查所有
     * @return
     */
    List<User> selectAll();

    /**
     * 插入用户
     * @param user 用户对象
     * @return
     */
    Integer insertUser(User user);
    
}
