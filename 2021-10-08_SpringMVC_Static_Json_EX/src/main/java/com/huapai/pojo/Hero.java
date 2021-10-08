package com.huapai.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.huapai.serialize.MyJsonSerialize;
import com.huapai.serialize.MyObjectSerializer;
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
public class Hero {
    
    @JSONField(name = "id")
    private Integer id;
    private String username;
    
    @JSONField(serialize = false)
    private String password;
    
    @JSONField(format = "yyyy-MM-dd")
    private Date birth;
    
    @JSONField(serializeUsing = MyObjectSerializer.class)
    private Double balance;
    
}
