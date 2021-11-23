package com.huapai;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@SpringBootApplication
@EnableDubbo
public class BootDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDubboProviderApplication.class, args);
    }

}
