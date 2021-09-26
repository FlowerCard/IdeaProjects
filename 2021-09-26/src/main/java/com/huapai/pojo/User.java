package com.huapai.pojo;

import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
@Data
public class User {
    
    private Integer id;
    private String username;
    private String password;
    private String info;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password, String info) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.info = info;
    }
}
