package com.huapai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
     * 1：男
     * 2：女
     */
    private Integer empGender;
    /**
     * 邮箱
     */
    private String empEmail;
    /**
     * 入职日期
     */
    private Date empEntryDate;
    /**
     * 离职日期
     */
    private Date empDepartureDate;
    /**
     * 住址
     */
    private String empAdder;
}
