package com.huapai.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/14.
 */
@Data
public class User {
    
    private Integer id;
    private String username;
    private String password;
    private String[] hobby;
    private List<String> friends;
    private Map<String,String> phones;
    
}
