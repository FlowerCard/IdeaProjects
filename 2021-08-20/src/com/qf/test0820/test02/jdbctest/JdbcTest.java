package com.qf.test0820.test02.jdbctest;

import com.qf.test0820.test02.dao.ICountryDao;
import com.qf.test0820.test02.dao.IDepartmentDao;
import com.qf.test0820.test02.dao.IEmployeeDao;
import com.qf.test0820.test02.dao.impl.CountryDaoImpl;
import com.qf.test0820.test02.dao.impl.DepartmentDaoImpl;
import com.qf.test0820.test02.dao.impl.EmployeeDaoImpl;
import com.qf.test0820.test02.pojo.Countries;
import com.qf.test0820.test02.pojo.Department;
import com.qf.test0820.test02.pojo.Employee;
import com.qf.test0820.test02.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
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
public class JdbcTest {

    /**
     * 国家字段插入测试
     */
    @Test
    public void jdbcCountryDaoImplInsertTest(){
        ICountryDao countryDao = new CountryDaoImpl();
        String sql = "insert into t_countries (COUNTRY_ID, COUNTRY_NAME) VALUES (?,?)";
        Countries countries = new Countries("KR","Korea");
        try {
            int insert = countryDao.insert(countries, sql);
            System.out.println(insert > 0 ? "插入成功" : "插入失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * EmployeeDaoImplDelect测试
     */
    @Test
    public void jdbcEmployeeDaoImplDeleteTest(){
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            int i = employeeDao.deleteById(207L);
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * EmployeeDaoImplUpdate测试
     */
    @Test
    public void jdbcEmployeeDaoImplUpdateTest(){
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee(
                207L,"Pai","Hua","huapai@odcn.live","123456789",
                new Date(),"AC_ACCOUNT",25000L,0.0,101L,110L
        );
        try {
            int update = employeeDao.update(employee);
            if (update > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * EmployeeDaoImplInsert测试
     */
    @Test
    public void jdbcEmployeeDaoImplInsertTest(){
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee(
                207L,"Pai","Hua","huapai@odcn.live","123456789",
                new Date(),"AC_ACCOUNT",25000L,0.0,null,110L
        );
        try {
            int insert = employeeDao.insert(employee);
            if (insert > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * EmployeeDaoImplQuery测试
     */
    @Test
    public void jdbcEmployeeDaoImplQueryTest(){
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setEmployeeId(180L);
        try {
            Employee byId = employeeDao.findById(employee.getEmployeeId());
            System.out.println(byId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * EmployeeDaoImpl全查找测试
     */
    @Test
    public void jdbcEmployeeDaoImplQueryAllTest(){
        IEmployeeDao employeeDao = new EmployeeDaoImpl();
        try {
            List<Employee> all = employeeDao.findAll();
            for (Employee employee1 : all) {
                System.out.println(employee1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dao删除数据
     */
    @Test
    public void jdbcDaoDeleteTest(){
        IDepartmentDao departmentDao = new DepartmentDaoImpl();
        try {
            String sql = "delete from t_departments where DEPARTMENT_ID=?";
            int i = departmentDao.deleteById(2721L, sql);
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dao修改数据
     */
    @Test
    public void jdbcDaoUpdateTest(){
        IDepartmentDao departmentDao = new DepartmentDaoImpl();
        Department department = new Department(271L,"人事部",300L,"杭州");
        try {
            String sql = "update t_departments set MANAGER_ID=? where DEPARTMENT_ID=?";
            int i = departmentDao.update(department, sql);
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dao插入数据
     */
    @Test
    public void jdbcDaoInsertTest(){
        IDepartmentDao departmentDao = new DepartmentDaoImpl();
        Department department = new Department(271L,"人事部",210L,"杭州");
        try {
            String sql = "insert into t_departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?,?,?,?)";
            int insert = departmentDao.insert(department, sql);
            if (insert > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Dao根据ID查询
     */
    @Test
    public void jdbcDaoQueryByIdTest() {
        IDepartmentDao departmentDao = new DepartmentDaoImpl();
        Department department = new Department();
        department.setDepartmentId(270L);
        try {
            String sql = "select department_id, department_name, manager_id, location_id from t_departments where department_id=?";
            Department byId = departmentDao.findById(department.getDepartmentId(),sql);
            System.out.println(byId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Dao查询所有结果测试
     */
    @Test
    public void jdbcDaoQueryAllTest(){
        IDepartmentDao departmentDao = new DepartmentDaoImpl();
        try {
            String sql = "select department_id, department_name, manager_id, location_id from t_departments";
            List<Department> departments = departmentDao.findAll(sql);
            for (Department department1 : departments) {
                System.out.println(department1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdbcDeleteTest(){
        try {
            Connection connection = JdbcUtils.getConnection();
            String sql = "delete from t_departments where DEPARTMENT_ID=?";
            int delete = JdbcUtils.delete(connection, sql, 271);
            if (delete > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdbcInsertTest(){
        try {
            Connection connection = JdbcUtils.getConnection();
            String sql = "insert into t_departments (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?,?,?,?)";
            int insert = JdbcUtils.insert(connection, sql, 271, "市场部", 180, "杭州");
            if (insert > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdbcUpdateTest(){
        try {
            Connection connection = JdbcUtils.getConnection();
            String sql = "update t_departments set MANAGER_ID=? where DEPARTMENT_ID=?";
            int update = JdbcUtils.update(connection, sql, 169, 270);
            if (update > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdbcQueryById(){
        ResultSet resultSet = null;
        try {
            String sql = "select country_id, country_name from t_countries where COUNTRY_ID = ?";
            resultSet = JdbcUtils.jdbcQuery(JdbcUtils.getConnection(), sql, "CN");
            Countries countries = null;
            while (resultSet.next()) {
                String countryId = resultSet.getString(1);
                String countryName = resultSet.getString(2);
                countries = new Countries(countryId,countryName);
            }
            System.out.println(countries);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.release(resultSet,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void jdbcQueryTest(){
        ResultSet resultSet = null;
        try {
            String sql = "select country_id, country_name from t_countries";
            resultSet = JdbcUtils.jdbcQuery(JdbcUtils.getConnection(), sql);
            Countries countries;
            List<Countries> countriesList = new ArrayList<>();
            while (resultSet.next()) {
                String countryId = resultSet.getString(1);
                String countryName = resultSet.getString(2);
                countries = new Countries(countryId,countryName);
                countriesList.add(countries);
            }
            for (Countries countries1 : countriesList) {
                System.out.println(countries1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.release(resultSet,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
