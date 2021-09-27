package com.huapai.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Data
@Component
public class Hero {
    private Integer id;
    private String username;
    private String gender;
    private String info;
}
