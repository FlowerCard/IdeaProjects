package com.qf.test0820.test02.dao.impl;


import com.qf.test0820.test02.dao.IDepartmentDao;
import com.qf.test0820.test02.pojo.Department;
import com.qf.test0820.test02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门Dao接口实现类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public class DepartmentDaoImpl implements IDepartmentDao {

    /**
     * @param department 部门对象
     * @param sql        需要执行的SQL
     * @return           受影响行数
     * @throws SQLException SQL异常
     */
    @Override
    public int insert(Department department, String sql) throws SQLException {
//        String sql = "insert into t_departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?,?,?,?)";
        return JdbcUtils.insert(JdbcUtils.getConnection(),sql,department.getDepartmentId(),
                department.getDepartmentName(),department.getManagerId(),department.getLocationId());
    }

    /**
     * @param department   部门对象
     * @param sql
     * @return             受影响行数
     * @throws SQLException SQL异常
     */
    @Override
    public int update(Department department, String sql) throws SQLException {
//        String sql = "update t_departments set MANAGER_ID=? where DEPARTMENT_ID=?";
        return JdbcUtils.update(JdbcUtils.getConnection(),sql,department.getDepartmentId());
    }

    /**
     * @param departmentId  部门ID
     * @param sql
     * @return              受影响行数
     * @throws SQLException SQL异常
     */
    @Override
    public int deleteById(Long departmentId, String sql) throws SQLException {
//        String sql = "delete from t_departments where DEPARTMENT_ID=?";
        return JdbcUtils.delete(JdbcUtils.getConnection(),sql,departmentId);
    }

    /**
     * @return              返回结果列表
     * @throws SQLException SQL异常
     * @param sql
     */
    @Override
    public List<Department> findAll(String sql) throws SQLException {
//        String sql = "select department_id, department_name, manager_id, location_id from t_departments";
        List<Department> departments = new ArrayList<>();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            long departmentId = resultSet.getLong(1);
            String departmentName = resultSet.getString(2);
            long managerId = resultSet.getLong(3);
            String locationId = resultSet.getString(4);
            Department department = new Department(departmentId,departmentName,managerId,locationId);
            departments.add(department);
        }
        JdbcUtils.release(resultSet,preparedStatement);
        return departments;
    }

    /**
     * @param departmentId  部门ID
     * @return              返回结果对象
     * @throws SQLException SQL异常
     */
    @Override
    public Department findById(Long departmentId,String sql) throws SQLException {
//        String sql = "select department_id, department_name, manager_id, location_id from t_departments where department_id=?";
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,departmentId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Department department = new Department();
        while (resultSet.next()) {
            department.setDepartmentId(resultSet.getLong(1));
            department.setDepartmentName(resultSet.getString(2));
            department.setManagerId(resultSet.getLong(3));
            department.setLocationId(resultSet.getString(4));
        }
        JdbcUtils.release(resultSet,preparedStatement);
        return department;
    }
}
