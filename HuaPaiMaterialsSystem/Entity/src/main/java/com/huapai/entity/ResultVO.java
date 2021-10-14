package com.huapai.entity;

import lombok.Data;

@Data
public class ResultVO {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
