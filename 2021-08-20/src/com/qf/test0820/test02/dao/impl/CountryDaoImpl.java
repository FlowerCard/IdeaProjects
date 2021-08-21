package com.qf.test0820.test02.dao.impl;

import com.qf.test0820.test02.dao.ICountryDao;
import com.qf.test0820.test02.pojo.Countries;
import com.qf.test0820.test02.utils.JdbcUtils;

import java.sql.SQLException;

/**
 * 国家接口实现类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/21.
 */
public class CountryDaoImpl implements ICountryDao {


    /**
     * 通过ID删除
     *
     * @param countryId 需要删除的ID字段
     * @param sql       需要执行的SQL语句
     * @return 返回受影响行数
     */
    @Override
    public int deleteById(Long countryId, String sql) throws SQLException {
        return JdbcUtils.delete(JdbcUtils.getConnection(),sql,countryId);
    }

    /**
     * 更新
     *
     * @param countries 传入需要更新的对象
     * @param sql       需要执行的SQL语句
     * @return
     */
    @Override
    public int update(Countries countries, String sql) throws SQLException {
        return JdbcUtils.update(JdbcUtils.getConnection(),sql,countries.getCountryName(),countries.getCountryId());
    }

    /**
     * 插入
     *
     * @param countries 需要插入的对象
     * @param sql       需要执行的SQL
     * @return 返回受影响行数
     */
    @Override
    public int insert(Countries countries, String sql) throws SQLException {
        return JdbcUtils.insert(JdbcUtils.getConnection(),sql,countries.getCountryId(),countries.getCountryName());
    }
}
