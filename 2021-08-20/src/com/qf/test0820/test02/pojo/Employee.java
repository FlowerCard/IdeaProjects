package com.qf.test0820.test02.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 员工类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = -6510920586200791119L;
    //employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Long salary;
    private Double commissionPct;
    private Long managerId;
    private Long departmentId;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String lastName, String email, String phoneNumber,
                    Date hireDate, String jobId, Long salary, Double commissionPct, Long managerId, Long departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(hireDate, employee.hireDate) && Objects.equals(jobId, employee.jobId) && Objects.equals(salary, employee.salary) && Objects.equals(commissionPct, employee.commissionPct) && Objects.equals(managerId, employee.managerId) && Objects.equals(departmentId, employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commissionPct, managerId, departmentId);
    }
}
