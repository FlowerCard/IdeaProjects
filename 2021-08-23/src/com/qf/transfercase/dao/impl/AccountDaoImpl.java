package com.qf.transfercase.dao.impl;

import com.qf.transfercase.dao.IAccountDao;
import com.qf.transfercase.pojo.Account;
import com.qf.transfercase.utils.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * IAccountDao 实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class AccountDaoImpl implements IAccountDao {
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
        return JdbcUtils.commonUpdate(sql,id);
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
        String sql = "update t_account set account_num = ?,account_name = ?,account_balance = ? where id = ?";
        return JdbcUtils.commonUpdate(
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
        String sql = "insert into t_account (account_num, account_name, account_balance) VALUES (?,?,?)";
        return JdbcUtils.commonUpdate(
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
        String sql = "select id, account_num, account_name, account_balance from t_account where id = ?";
        PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(sql);
        preparedStatement.setLong(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        if (resultSet.next()) {
            account.setAccountId(resultSet.getLong(1));
            account.setAccountNum(resultSet.getString(2));
            account.setAccountName(resultSet.getString(3));
            account.setAccountBalance(resultSet.getDouble(4));
        }
        JdbcUtils.release(resultSet,preparedStatement,null);
        return account;
    }

    /**
     * 查询用户名对应的数学
     *
     * @param name 需要查询的用户名
     * @return 返回对象
     * @throws SQLException 异常
     */
    @Override
    public Account queryByName(String name) throws SQLException {

        String sql = "select id, account_num, account_name, account_balance from t_account where account_name = ?";
        PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        if (resultSet.next()) {
            account.setAccountId(resultSet.getLong(1));
            account.setAccountNum(resultSet.getString(2));
            account.setAccountName(resultSet.getString(3));
            account.setAccountBalance(resultSet.getDouble(4));
        }

        JdbcUtils.release(resultSet,null,null);
        return account;
    }

    /**
     * 查询所有数据
     *
     * @return 返回结果集列表
     * @throws SQLException 异常
     */
    @Override
    public List<Account> queryAll() throws SQLException {
        String sql = "select id, account_num, account_name, account_balance from t_account";
        PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = new Account();
        List<Account> accountList = new ArrayList<>();
        if (resultSet.next()) {
            while (resultSet.next()) {
                account.setAccountId(resultSet.getLong(1));
                account.setAccountNum(resultSet.getString(2));
                account.setAccountName(resultSet.getString(3));
                account.setAccountBalance(resultSet.getDouble(4));
                accountList.add(account);
            }
        }
        JdbcUtils.release(resultSet,preparedStatement,null);
        return accountList;
    }
}
