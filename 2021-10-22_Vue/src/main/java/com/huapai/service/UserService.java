package com.huapai.service;

import com.github.pagehelper.PageInfo;
import com.huapai.entity.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/22.
 */
public interface UserService {

    /**
     * 分页查询所有
     * @return 分页信息
     */
    PageInfo<List<User>> queryAll(Integer page,Integer limit);

    /**
     * 通过ID查询
     * @param id 用户id
     * @return 用户对象
     */
    User queryById(Integer id);

    /**
     * 修改用户
     * @param user 用户对象
     * @return 是否成功
     */
    Boolean modifyUser(User user);

    /**
     * 添加用户
     * @param user 用户对象
     * @return 是否成功
     */
    Boolean addUser(User user);

    /**
     * 删除用户---真实删除
     * @param id 用户ID
     * @return 是否成功
     */
    Boolean removeUser(Integer id);
    
}
