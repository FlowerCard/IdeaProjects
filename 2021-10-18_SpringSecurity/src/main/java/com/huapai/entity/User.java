package com.huapai.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/18.
 */
@Data
@Component
public class User implements Serializable {
    
    private static final long serialVersionUID = 42L;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String info;
    private String role;
    private String auth;

}
