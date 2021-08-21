package com.qf.test0820.test02.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 部门类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/20.
 */
public class Department implements Serializable {

    private static final long serialVersionUID = -1305515842023052220L;
    private Long departmentId;
    private String departmentName;
    private Long managerId;
    private String locationId;

    public Department() {
    }

    public Department(Long departmentId, String departmentName, Long managerId, String locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId) && Objects.equals(departmentName, that.departmentName) && Objects.equals(managerId, that.managerId) && Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, managerId, locationId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", managerId=" + managerId +
                ", locationId='" + locationId + '\'' +
                '}';
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
