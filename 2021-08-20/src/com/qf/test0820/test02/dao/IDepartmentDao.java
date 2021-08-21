package com.qf.test0820.test02.dao;

import com.qf.test0820.test02.pojo.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public interface IDepartmentDao {

    /**
     * 插入
     *
     * @param department    部门对象
     * @param sql           需要执行的SQL
     * @return              受影响行数
     */
    public int insert(Department department,String sql) throws SQLException;

    /**
     * 更新
     * @param department    对象
     * @param sql           需要执行的SQL
     * @return              受影响行数
     */
    public int update(Department department, String sql) throws SQLException;

    /**
     *
     * @param departmentId  部门ID
     * @param sql           需要执行的SQL
     * @return              受影响行数
     */
    public int deleteById(Long departmentId,String sql) throws SQLException;

    /**
     * 查找全字段
     * @param sql   需要执行的SQL
     * @return      返回值列表
     */
    public List<Department> findAll(String sql) throws SQLException;

    /**
     * 查询单字段
     * @param departmentId  部门ID
     * @param sql           需要执行的SQL
     * @return              返回部门对象
     */
    public Department findById(Long departmentId,String sql) throws SQLException;

}
