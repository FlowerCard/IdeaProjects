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
     * @return              受影响行数
     */
    public int insert(Department department) throws SQLException;

    /**
     * 更新
     * @return              受影响行数
     */
    public int updateById(Department department) throws SQLException;

    /**
     *
     * @param departmentId  部门ID
     * @return              受影响行数
     */
    public int deleteById(Long departmentId) throws SQLException;

    /**
     * 查找全字段
     * @return      返回值列表
     */
    public List<Department> findAll() throws SQLException;

    /**
     * 查询单字段
     * @param departmentId  部门ID
     * @return              返回部门对象
     */
    public Department findById(Long departmentId) throws SQLException;

}
