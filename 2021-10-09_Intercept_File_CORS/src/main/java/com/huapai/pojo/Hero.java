package com.huapai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    
    private Integer id;
    private String username;
    private String adder;
    private String info;
    
}
