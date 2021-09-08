package com.huapai.dao.impl;

import com.huapai.dao.IUserDao;
import com.huapai.pojo.User;
import com.huapai.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */
public class UserDaoImpl implements IUserDao {
    
    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
    
    /**
     * 删除用户
     *
     * @param id 账户ID
     * @return 受影响行数
     */
    @Override
    public int deleteById(String id) throws SQLException {
        String sql = "update t_account set isdelete = 1 where id = ?";
        return queryRunner.update(
                sql,
                id
        );
    }

    /**
     * 更新用户
     *
     * @param user 更新的用户信息
     * @return 受影响行数
     */
    @Override
    public int update(User user) throws SQLException {
        String sql = "update t_account set useraccount = ?,username = ?,password = ?,realname = ?,idcode = ?," +
                "modified_time = ? where id = ?";
        return queryRunner.update(
                sql,
                user.getUseraccount(),user.getUsername(),user.getPassword(), user.getRealname(),user.getIdcode(),
                user.getModifiedTime(),user.getId()
        );
    }

    /**
     * 插入用户
     *
     * @param user 插入的用户信息
     * @return 受影响行数
     */
    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "insert into t_account (useraccount, username, password, create_time, modified_time) \n" +
                "VALUES (?,?,?,?,?)";
        return queryRunner.update(
                sql,
                user.getUseraccount(),user.getUsername(),user.getPassword(),user.getCreateTime(),user.getModifiedTime()
        );
    }

    /**
     * 根据账号查询用户
     *
     * @param account 账号
     * @return 用户对象
     */
    @Override
    public User queryByAccount(String account) {
        return null;
    }

    /**
     * 查询所有
     *
     * @return 用户列表
     */
    @Override
    public List<User> queryAll() {
        return null;
    }
}
