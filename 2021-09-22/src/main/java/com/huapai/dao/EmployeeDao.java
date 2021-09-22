package com.huapai.dao;

import com.huapai.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
public interface EmployeeDao {

    /**
     * 通过ID查询
     * @param empId id
     * @return
     */
    Employee selectById(Integer empId);

    /**
     * 查所有
     * @return
     */
    List<Employee> selectAll();

    /**
     * 插入员工
     * @param employee 员工对象
     * @return
     */
    Integer insertEmployee(Employee employee);

    /**
     * 通过ID更新员工
     * @param empId            员工ID
     * @param empName          员工姓名
     * @param empAge           员工年龄
     * @param empGender        员工性别
     * @param empEmail         邮箱
     * @param empEntryDate     入职日期
     * @param empDepartureDate 离职日期
     * @param empAdder          地址
     * @return
     */
    Integer updateById(@Param("empId") Integer empId, @Param("empName") String empName, @Param("empAge") Integer empAge,
                       @Param("empGender") Integer empGender, @Param("empEmail") String empEmail,
                       @Param("empEntryDate") Date empEntryDate, @Param("empDepartureDate") Date empDepartureDate,
                       @Param("empAdder") String empAdder);

    /**
     * 通过ID删除
     * @param empId 员工ID
     * @return
     */
    Integer deleteById(Integer empId);
    
}
