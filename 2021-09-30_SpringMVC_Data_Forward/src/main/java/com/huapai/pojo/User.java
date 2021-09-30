package com.huapai.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/1.
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date birth;
}
