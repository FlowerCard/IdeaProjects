package com.huapai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@SpringBootApplication
@MapperScan("com.huapai.dao")
public class MyProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyProviderApplication.class,args);
    }
}
