package com.qf.test0820.test02.dao;

import com.qf.test0820.test02.pojo.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * 员工Dao接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public interface IEmployeeDao {

    /**
     * 删除
     * @param employeeId    需要删除的ID数据
     * @return              返回受影响行
     */
    public int deleteById(Long employeeId) throws SQLException;

    /**
     * 更新
     * @param employee 需要更新的对象
     * @return         返回受影响行数
     */
    public int update(Employee employee) throws SQLException;

    /**
     * 插入
     * @param employee  需要插入的对象
     * @return          返回受影响行数
     */
    public int insert(Employee employee) throws SQLException;

    /**
     * 查找所有字段
     * @return 返回结果列表
     */
    public List<Employee> findAll() throws SQLException;

    /**
     * 通过ID查询
     * @param employeeId    对象ID
     * @return              返回结果对象
     */
    public Employee findById(Long employeeId) throws SQLException;
}
