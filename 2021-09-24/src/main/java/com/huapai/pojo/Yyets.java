package com.huapai.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */
@Data
public class Yyets implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
     * 编号
     */
    private Integer id;
    /**
     * 中文名
     */
    private String cnname;
    /**
     * 英文名
     */
    private String enname;
    /**
     * 别名
     */
    private String aliasname;
    /**
     * 
     */
    private Integer views;
    /**
     * 数据
     */
    private String data;
}
