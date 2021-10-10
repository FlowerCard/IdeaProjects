package com.huapai.service;

import com.huapai.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
public interface IUserService {

    /**
     * 搜索所有用户
     * @return 用户集合
     */
    public List<User> searchAllUsers();

    /**
     * 通过用户ID查询
     * @param id 用户ID
     * @return 用户对象
     */
    public User searchUserById(Integer id);

    /**
     * 新增用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer addUser(User user);
    
}
