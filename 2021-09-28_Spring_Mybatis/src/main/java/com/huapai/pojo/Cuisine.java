package com.huapai.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_cuisine
 * @author 
 */
@Data
public class Cuisine implements Serializable {
    /**
     * 菜系ID
     */
    private Integer tCuisineId;

    /**
     * 菜系名称
     */
    private String tCuisineName;

    /**
     * 创建时间
     */
    private Date tCuisineCreateTime;

    /**
     * 修改时间
     */
    private Date tCuisineModifieTime;

    /**
     * 修改人
     */
    private Integer tCuisineModifieUser;

    private static final long serialVersionUID = 1L;
}