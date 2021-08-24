package com.work.dao;

import com.work.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public interface ILoginDao {

    /**
     * 插入
     * @param user 需要插入的对象
     * @return        受影响行数
     * @throws SQLException 异常
     */
    public int insert(User user) throws SQLException;

    /**
     * 查询用户名对应的数据
     * @param account  需要查询的用户名
     * @return      返回对象
     * @throws SQLException 异常
     */
    public User queryByAccount(String account) throws SQLException;

    /**
     * 查询所有数据
     * @return  返回结果集列表
     * @throws SQLException 异常
     */
    public List<User> queryAll() throws SQLException;

}
