package com.huapai.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/22.
 */
@Data
public class ResultVO<T> implements Serializable {
    
    private static final long serialVersionUID = 42L;
    
    private Integer code;
    private String message;
    private T data;
    
}
