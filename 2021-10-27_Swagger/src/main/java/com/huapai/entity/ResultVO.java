package com.huapai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/27.
 * 封装返回数据
 */
@Data
@ApiModel(value = "返回数据封装", description = "封装返回的信息和数据")
public class ResultVO implements Serializable {
    
    private static final long serialVersionUID = 42L;

    /**
     * 返回代码
     */
    @ApiModelProperty(name = "core", value = "返回状态代码")
    private Integer code;

    /**
     * 返回信息
     */
    @ApiModelProperty(name = "message", value = "返回携带的信息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(name = "data", value = "返回携带的数据")
    private Object data;
    
}
