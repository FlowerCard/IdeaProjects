package com.huapai.dao.impl;

import com.huapai.dao.IUserDao;
import com.huapai.pojo.User;
import com.huapai.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
public class UserDaoImpl implements IUserDao {

    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    /**
     * 删除
     *
     * @param account 账号
     * @return 受影响行数
     * @throws SQLException SQL异常
     */
    @Override
    public int deleteByAccount(String account) throws SQLException {
        String sql = "delete from t_account where useraccount = ?";
        return queryRunner.update(
                sql,
                account
        );
    }

    /**
     * 插入
     *
     * @param user 用户
     * @return 受影响行数
     * @throws SQLException SQL异常
     */
    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "insert into t_account (useraccount, username, password, create_time, modified_time) VALUES (?,?,?,?,?)";
        return queryRunner.update(
                sql,
                user.getUseraccount(),user.getUsername(),user.getPassword(),new Date(),new Date()
        );
    }

    /**
     * 更新
     *
     * @param user 用户
     * @return 受影响行数
     * @throws SQLException SQL异常
     */
    @Override
    public int updateUser(User user) throws SQLException {
        String sql = "update t_account set username = ?,password = ?,realname = ?,idcode = ?,modified_time = ?" +
                ",status = ?,isdelete = ? where id = ?";
        return queryRunner.update(
                sql,
                user.getUsername(),user.getPassword(),user.getRealname(),user.getIdcode(),new Date(),user.getStatus(),
                user.getIsdelete(),user.getId()
        );
    }

    /**
     * 查单个
     *
     * @param account 账户
     * @return 用户对象
     * @throws SQLException SQL异常
     */
    @Override
    public User queryByAccount(String account) throws SQLException {
        String sql = "select id, useraccount, username, password, realname, idcode, create_time, modified_time, status, " +
                "isdelete from t_account where useraccount = ?";
        return queryRunner.query(
                sql,
                new BeanHandler<>(User.class),
                account
        );
    }

    /**
     * 查所有
     *
     * @return 用于列表
     * @throws SQLException SQL异常
     */
    @Override
    public List<User> queryAll() throws SQLException {
        String sql = "select id, useraccount, username, password, realname, idcode, create_time, modified_time, status, " +
                "isdelete from t_account";
        return queryRunner.query(
                sql,
                new BeanListHandler<>(User.class)
        );
    }
}
