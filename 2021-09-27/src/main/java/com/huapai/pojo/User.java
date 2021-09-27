package com.huapai.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Data
@Component
public class User {
    @Value("1001")
    private Integer id;
    @Value("注解测试01")
    private String username;
    @Value("女")
    private String gender;
    @Value("注解测试类01")
    private String info;
    
}
