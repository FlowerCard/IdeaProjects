package com.huapai.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * worksite
 * @author 
 */
@Data
public class Worksite implements Serializable {
    /**
     * 工地id
     */
    private Integer workId;

    /**
     * 工地名称
     */
    private String workName;

    /**
     * 工地地址
     */
    private String workAddr;

    /**
     * 此id跟城市id对应
     */
    private Integer cityId;

    /**
     * 此id跟用户表id对应
     */
    private Integer uId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除  0:未删除  1:已删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}