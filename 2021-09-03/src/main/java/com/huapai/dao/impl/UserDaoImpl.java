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
 * Created on 2021/9/3.
 */
public class UserDaoImpl implements IUserDao {

    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    /**
     * 根据用户账号删除
     *
     * @param delAccount 需要被删除的账号
     * @return 返回受影响行数
     */
    @Override
    public int deleteByAccount(String delAccount) throws SQLException {
        //执行的SQL
        String sql = "delete from t_account where useraccount = ?";
        return queryRunner.update(sql);
    }

    /**
     * 修改用户
     *
     * @param user 需要修改的用户信息
     * @return 返回受影响行数
     */
    @Override
    public int modifyUser(User user) throws SQLException {
        String sql = "update t_account set useraccount = ?,username = ?,password = ?,modified_time = ?, status = ?," +
                "isdelete = ? where id = ?";
        return queryRunner.update(
                sql,
                user.getUseraccount(), user.getUsername(),user.getPassword(),new Date(),user.getStatus(),user.getIsdelete(),
                user.getId());
    }

    /**
     * 插入用户
     *
     * @param user 需要插入的用户
     * @return 返回受影响行数
     */
    @Override
    public int insertUser(User user) throws SQLException {
        String sql = "insert into t_account (useraccount, username, password, realname, idcode, create_time, modified_time)\n" +
                "values (?,?,?,?,?,?,?)";
        return queryRunner.update(
                sql,
                user.getUseraccount(),user.getUsername(),user.getPassword(),user.getRealname(),user.getIdcode(),new Date(),new Date()
        );
    }

    /**
     * 通过账户查用户
     *
     * @param account 账户
     * @return 返回用户对象
     */
    @Override
    public User queryByAccount(String account) throws SQLException {
        String sql = "select id, useraccount, username, password, realname, idcode, create_time, modified_time, status, " +
                "isdelete from t_account where useraccount = ?";
        return queryRunner.query(sql,new BeanHandler<>(User.class),account);
    }

    /**
     * 查询所有用户
     *
     * @return 返回用户列表
     */
    @Override
    public List<User> queryAll() throws SQLException {
        String sql = "select id, useraccount, username, password, realname, idcode, create_time, modified_time," +
                " status, isdelete from t_account";
        return queryRunner.query(sql,new BeanListHandler<>(User.class));
    }
}
