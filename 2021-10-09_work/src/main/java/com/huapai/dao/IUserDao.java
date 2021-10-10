package com.huapai.dao;

import com.huapai.constant.SqlConstant;
import com.huapai.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Repository("userDao")
public interface IUserDao {

    /**
     * 查找所有用户
     * @return 用户列表
     */
    @Select(SqlConstant.SELECT_ALL_USERS)
    public List<User> selectAllUsers();

    /**
     * 通过用户ID查询
     * @param id 用户ID
     * @return 用户对象
     */
    @Select(SqlConstant.SELECT_USER_BY_ID)
    public User selectUserById(Integer id);

    /**
     * 插入用户
     * @param user 用户对象
     * @return 受影响行数
     */
    @Select(SqlConstant.INSERT_USER)
    public Integer insertUser(User user);

    /**
     * 通过用户ID修改用户
     * @param user 用户对象
     * @return 受影响行数
     */
    @Select(SqlConstant.UPDATE_USER_BY_ID)
    public Integer updateUserById(User user);

    /**
     * 通过id删除用户
     * @param id 用户id
     * @return 受影响行数
     */
    @Select(SqlConstant.DELETE_USER_BY_ID)
    public Integer deleteUserById(Integer id);
    
}
