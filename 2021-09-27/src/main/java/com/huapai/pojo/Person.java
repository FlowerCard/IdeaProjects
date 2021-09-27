package com.huapai.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Data
public class Person {
    private Integer id;
    private String username;
    private String gender;
    private String info;
    
    private String[] hobbies;
    private List<String> friends;
    private Map<String,String> phones;
}
