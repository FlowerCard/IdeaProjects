package com.huapai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    
    private Integer id;
    private String username;
    private String password;
    private String info;
    
}
