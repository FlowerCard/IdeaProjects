package com.huapai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MyConsumerNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyConsumerNacosApplication.class, args);
    }

}
