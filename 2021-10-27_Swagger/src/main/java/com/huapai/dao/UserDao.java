package com.huapai.dao;

import com.huapai.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/27.
 */
@Repository("userDao")
public interface UserDao {
    /**
     * 删除记录
     * @param id 记录ID
     * @return 受影响行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录
     * @param record 记录对象
     * @return 受影响行数
     */
    int insert(User record);

    /**
     * 动态SQL插入记录
     * @param record 记录对象
     * @return 受影响行数
     */
    int insertSelective(User record);

    /**
     * 通过主键查询
     * @param id 主键
     * @return 记录对象
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return 记录对象结果集
     */
    List<User> selectAll();

    /**
     * 通过用户名查询
     * @param username 用户名
     * @return 用户对象
     */
    User selectByUsername(String username);

    /**
     * 根据主键动态使用动态SQL更新
     * @param record 记录对象
     * @return 受影响行数
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键更新
     * @param record 记录对象
     * @return 受影响行数
     */
    int updateByPrimaryKey(User record);
}