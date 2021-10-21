package com.huapai.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/21.
 */
@Data
@ApiModel(value = "ResultVO对象",description = "封装接口给前端的数据")
public class ResultVO<T> implements Serializable {
    
    private static final long serialVersionUID = 42L;
    
    @ApiModelProperty(value = "状态码",dataType = "int")
    private Integer code;
    @ApiModelProperty(value = "响应信息",dataType = "string")
    private String message;
    @ApiModelProperty(value = "泛型返回数据",dataType = "object")
    private T data; 
    
    
}
