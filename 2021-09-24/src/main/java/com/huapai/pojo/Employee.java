package com.huapai.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
     * 员工ID
     */
    private Integer empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工年龄
     */
    private Integer empAge;
    /**
     * 员工性别
     */
    private Integer empGender;
    /**
     * 员工邮箱
     */
    private String empEmail;
    /**
     * 入职时间
     */
    private Date empEntryDate;
    /**
     * 离职时间
     */
    private Date empDepartureDate;
    /**
     * 员工住址
     */
    private String empAdder;
}
