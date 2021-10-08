package com.huapai.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.huapai.serialize.MyJsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * Jackson属性别名
     */
    @JsonProperty("id")
    private Integer id;
    private String username;

    /**
     * Jackson忽略属性
     */
    @JsonIgnore
    private String password;

    /**
     * 格式化Jackson日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /**
     * Jackson忽略空属性
     * Jackson自定义序列化
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = MyJsonSerialize.class)
    private Double balance;
    
}
