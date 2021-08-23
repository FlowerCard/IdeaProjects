package com.work.dao.impl;

import com.work.dao.IAccountDao;
import com.work.pojo.Account;
import com.work.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * IAccountDao 实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner = null;

    /**
     * 通过ID删除
     *
     * @param id 需要删除的ID对应数据
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int deleteById(Long id) throws SQLException {
        String sql = "delete from t_account where id = ?";
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.update(DbUtils.getConnection(),sql,id);
    }


    /**
     * 更新
     *
     * @param account 需要更新的对象
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int update(Account account) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "update t_account set account_num = ?,account_name = ?,account_balance = ? where id = ?";
        return queryRunner.update(
                DbUtils.getConnection(),
                sql,
                account.getAccountNum(),account.getAccountName(),account.getAccountBalance(),account.getAccountId()
        );
    }

    /**
     * 插入
     *
     * @param account 需要插入的对象
     * @return 受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int insert(Account account) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "insert into t_account (account_num, account_name, account_balance) VALUES (?,?,?)";
        return queryRunner.update(
                DbUtils.getConnection(),
                sql,
                account.getAccountNum(),account.getAccountName(),account.getAccountBalance()
        );
    }

    /**
     * 查询对应ID的数据
     *
     * @param id 需要查询的ID
     * @return 返回对象
     * @throws SQLException 异常
     */
    @Override
    public Account queryById(Long id) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "select id accountId, account_num accountNum , " +
                "account_name accountName, account_balance accountBalance from t_account where id = ?";
        return queryRunner.query(sql, new BeanHandler<>(Account.class), id);
    }

    /**
     * 查询用户名对应的数据
     *
     * @param name 需要查询的用户名
     * @return 返回对象
     * @throws SQLException 异常
     */
    @Override
    public Account queryByName(String name) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "select id accountId, account_num accountNum, " +
                "account_name accountName, account_balance accountBalance from t_account where account_name = ?";
        return queryRunner.query(sql, new BeanHandler<>(Account.class), name);
    }

    /**
     * 查询账户对应的数据
     *
     * @param num 账户
     * @return 返回用户对象
     * @throws SQLException 异常
     */
    @Override
    public Account queryByNum(String num) throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "select id accountId, account_num accountNum, " +
                "account_name accountName, account_balance accountBalance from t_account where account_num = ?";
        return queryRunner.query(sql, new BeanHandler<>(Account.class), num);
    }

    /**
     * 查询所有数据
     *
     * @return 返回结果集列表
     * @throws SQLException 异常
     */
    @Override
    public List<Account> queryAll() throws SQLException {
        queryRunner = new QueryRunner(DbUtils.getDataSource());
        String sql = "select id accountId, account_num accountNum, " +
                "account_name accountName, account_balance  accountBalance from t_account";
        return queryRunner.query(sql, new BeanListHandler<>(Account.class));
    }
}
