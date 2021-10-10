package com.huapai.bean;

import lombok.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/10.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    
    private Integer id;
    private String username;
    private String password;
    private String info;
    
}
