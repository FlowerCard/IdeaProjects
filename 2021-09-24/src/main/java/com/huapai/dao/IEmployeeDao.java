package com.huapai.dao;

import com.huapai.pojo.Employee;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */
public interface IEmployeeDao {
    
    public Employee selectById(Integer empId);
    public List<Employee> selectByCondition(Employee employee);
    
}
