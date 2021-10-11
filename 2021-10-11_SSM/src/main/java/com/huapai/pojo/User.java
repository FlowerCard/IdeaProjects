package com.huapai.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/11.
 * User实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    
    private Integer id;
    private String username;
    
    @JSONField(serialize = false)
    private String password;
    private String email;
    private String info;
    
}
