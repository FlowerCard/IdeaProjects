package com.qf.java2105.huangzihao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜系实体类
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Cuisine implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 菜系ID
     */
    private Integer cuisineId;
    /**
     * 菜系名称
     */
    private String cuisineName;
    /**
     * 菜系创建时间
     */
    private Date cuisineCreateTime;
    /**
     * 菜系修改时间
     */
    private Date cuisineModifieTime;

    /**
     * 修改菜系用户ID
     */
    private Integer cuisineModifieUser;

    public Cuisine() {
    }

    public Cuisine(Integer cuisineId, String cuisineName, Date cuisineCreateTime, Date cuisineModifieTime, Integer cuisineModifieUser) {
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
        this.cuisineCreateTime = cuisineCreateTime;
        this.cuisineModifieTime = cuisineModifieTime;
        this.cuisineModifieUser = cuisineModifieUser;
    }

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public Date getCuisineCreateTime() {
        return cuisineCreateTime;
    }

    public void setCuisineCreateTime(Date cuisineCreateTime) {
        this.cuisineCreateTime = cuisineCreateTime;
    }

    public Date getCuisineModifieTime() {
        return cuisineModifieTime;
    }

    public void setCuisineModifieTime(Date cuisineModifieTime) {
        this.cuisineModifieTime = cuisineModifieTime;
    }

    public Integer getCuisineModifieUser() {
        return cuisineModifieUser;
    }

    public void setCuisineModifieUser(Integer cuisineModifieUser) {
        this.cuisineModifieUser = cuisineModifieUser;
    }
    
    
    

}
