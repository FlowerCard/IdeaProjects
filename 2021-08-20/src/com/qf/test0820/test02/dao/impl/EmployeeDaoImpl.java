package com.qf.test0820.test02.dao.impl;

import com.qf.test0820.test02.dao.IEmployeeDao;
import com.qf.test0820.test02.pojo.Employee;
import com.qf.test0820.test02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public class EmployeeDaoImpl implements IEmployeeDao {
    /**
     * 删除
     *
     * @param employeeId 需要删除的ID数据
     * @param sql        需要执行的SQL
     * @return 返回受影响行
     */
    @Override
    public int deleteById(Long employeeId, String sql) throws SQLException {
//        String sql = "delete from t_employees where EMPLOYEE_ID=?";
        return JdbcUtils.delete(JdbcUtils.getConnection(),sql,employeeId);
    }

    /**
     * 更新
     *
     * @param employee 需要更新的对象
     * @param sql      需要执行的SQL
     * @return 返回受影响行数
     */
    @Override
    public int update(Employee employee, String sql) throws SQLException {
//        String sql = "update t_employees set MANAGER_ID=? where EMPLOYEE_ID=?";
        return JdbcUtils.update(JdbcUtils.getConnection(),sql,employee.getManagerId(),employee.getEmployeeId());
    }

    /**
     * 插入
     *
     * @param employee 需要插入的对象
     * @param sql      需要执行的SQL
     * @return 返回受影响行数
     */
    @Override
    public int insert(Employee employee, String sql) throws SQLException {
//        String sql = "insert into t_employees (employee_id, first_name, last_name, email, phone_number, hire_date, " +
//                "job_id, salary, commission_pct, manager_id, department_id) \n" +
//                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        return JdbcUtils.insert(JdbcUtils.getConnection(),sql,employee.getEmployeeId(),employee.getFirstName(),
                employee.getLastName(),employee.getEmail(),employee.getPhoneNumber() ,employee.getHireDate(),
                employee.getJobId(),employee.getSalary(), employee.getCommissionPct(), employee.getManagerId(),
                employee.getDepartmentId());
    }

    /**
     * 查找所有字段
     *
     * @param sql   需要执行的SQL
     * @return 返回结果列表
     */
    @Override
    public List<Employee> findAll(String sql) throws SQLException {
//        String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary," +
//                " commission_pct, manager_id, department_id from t_employees";
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        while (resultSet.next()) {
            long employeeId = resultSet.getLong("employee_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String phoneNumber = resultSet.getString("phone_number");
            Date hireDate = resultSet.getDate("hire_date");
            String jobId = resultSet.getString("job_id");
            long salary = resultSet.getLong("salary");
            double commissionPct = resultSet.getDouble("commission_pct");
            long managerId = resultSet.getLong("manager_id");
            long departmentId = resultSet.getLong("department_id");
            employee = new Employee(employeeId,firstName,lastName,email,phoneNumber,hireDate,jobId,salary,
                    commissionPct,managerId,departmentId);
            employeeList.add(employee);
        }
        JdbcUtils.release(resultSet,preparedStatement);
        return employeeList;
    }

    /**
     * 通过ID查询
     *
     * @param employeeId 对象ID
     * @param sql        需要执行的SQL
     * @return 返回结果对象
     */
    @Override
    public Employee findById(Long employeeId, String sql) throws SQLException {
//        String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, " +
//                "commission_pct, manager_id, department_id from t_employees where EMPLOYEE_ID=?";
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,employeeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Employee employee = null;
        while (resultSet.next()) {
            long employeeId1 = resultSet.getLong("employee_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String phoneNumber = resultSet.getString("phone_number");
            Date hireDate = resultSet.getDate("hire_date");
            String jobId = resultSet.getString("job_id");
            long salary = resultSet.getLong("salary");
            double commissionPct = resultSet.getDouble("commission_pct");
            long managerId = resultSet.getLong("manager_id");
            long departmentId = resultSet.getLong("department_id");
            employee = new Employee(employeeId1,firstName,lastName,email,phoneNumber,hireDate,jobId,salary,
                    commissionPct,managerId,departmentId);
        }
        return employee;
    }
}
