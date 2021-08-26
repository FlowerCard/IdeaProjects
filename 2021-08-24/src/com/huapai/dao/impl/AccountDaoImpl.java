package com.huapai.dao.impl;

import com.huapai.dao.IAccountDao;
import com.huapai.pojo.Account;
import com.huapai.utils.DbUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/24.
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner = null;

    /**
     * 查询所有
     *
     * @return 返回对象结果列表
     * @throws SQLException 异常
     */
    @Override
    public List<Account> queryAll() throws SQLException {
        queryRunner = new QueryRunner(DbUtil.getDataSource());
        String sql = "select id, account_num accountNum, account_name accountName, account_balance balance from t_account";
        return queryRunner.query(sql, new BeanListHandler<>(Account.class));
    }

    /**
     * 通过用户Num查询
     *
     * @param accountNum 用户num
     * @return 返回用户对象
     * @throws SQLException 异常
     */
    @Override
    public Account queryByNum(String accountNum) throws SQLException {
        queryRunner = new QueryRunner(DbUtil.getDataSource());
        String sql = "select id, account_num accountNum, account_name accountName, account_balance balance from t_account where account_num = ?";
        return queryRunner.query(sql, new BeanHandler<>(Account.class), accountNum);
    }

    /**
     * 插入
     *
     * @param account 用户对象
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int insert(Account account) throws SQLException {
        queryRunner = new QueryRunner(DbUtil.getDataSource());
        String sql = "insert into t_account (account_num, account_name, account_balance) VALUES (?,?,?)";
        int row = queryRunner.update(
                DbUtil.getConnection(),
                sql,
                account.getAccountNum(),account.getAccountName(),account.getBalance()
        );
        return row;
    }

    /**
     * 更新
     *
     * @param account 用户对象
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int update(Account account) throws SQLException {
        queryRunner = new QueryRunner(DbUtil.getDataSource());
        String sql = "update t_account set account_num = ?,account_name = ?, account_balance = ? where id = ?";
        int row = queryRunner.update(
                DbUtil.getConnection(),
                sql,
                account.getAccountNum(), account.getAccountName(), account.getBalance(), account.getId()
        );
        return row;
    }

    /**
     * 删除
     *
     * @param accountId 用户Num
     * @return 返回受影响行数
     * @throws SQLException 异常
     */
    @Override
    public int deleteById(String accountId) throws SQLException {
        queryRunner = new QueryRunner(DbUtil.getDataSource());
        String sql = "delete from t_account where id = ?";
        int row = queryRunner.update(
                DbUtil.getConnection(),
                sql,
                accountId
        );
        return row;
    }
}
