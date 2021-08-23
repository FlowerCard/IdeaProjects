package com.work.dao.impl;

import com.work.dao.ILoginDao;
import com.work.pojo.User;
import com.work.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class LoginDaoImpl implements ILoginDao {

    private QueryRunner queryRunner = null;

    /**
     * 插入
     *
     * @param user 需要插入的对象
     * @return 受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int insert(User user) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "insert into t_login (useraccount, username, password, balance) VALUES (?,?,?,?)";
        return queryRunner.update(
                DbUtils.getConnection(),
                sql,
                user.getUseraccount(), user.getUsername(), user.getPassword(), user.getBalance()
                );
    }

    /**
     * 查询用户名对应的数据
     *
     * @param account 需要查询的用户名
     * @param password  密码
     * @return 返回对象
     * @throws SQLException 异常
     */
    @Override
    public User queryByAccount(String account, String password) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "select id, useraccount, username, password, balance from t_login where useraccount = ? and password = ?";
        return queryRunner.query(
                sql,
                new BeanHandler<>(User.class),
                account,
                password
        );
    }

    /**
     * 查询所有数据
     *
     * @return 返回结果集列表
     * @throws SQLException 异常
     */
    @Override
    public List<User> queryAll() throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "select id, useraccount, username, password, balance from t_login";
        return queryRunner.query(
                sql,
                new BeanListHandler<>(User.class)
        );
    }
}
