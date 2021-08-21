package com.qf.test0820.test02.dao;

import com.qf.test0820.test02.pojo.Countries;

import java.sql.SQLException;

/**
 * 国家接口Dao
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/21.
 */
public interface ICountryDao {

    /**
     * 通过ID删除
     * @param countryId 需要删除的ID字段
     * @param sql       需要执行的SQL语句
     * @return          返回受影响行数
     */
    public int deleteById(Long countryId,String sql) throws SQLException;

    /**
     * 更新
     * @param countries 传入需要更新的对象
     * @param sql       需要执行的SQL语句
     * @return
     */
    public int update(Countries countries,String sql) throws SQLException;

    /**
     * 插入
     * @param countries 需要插入的对象
     * @param sql       需要执行的SQL
     * @return          返回受影响行数
     */
    public int insert(Countries countries,String sql) throws SQLException;

}
