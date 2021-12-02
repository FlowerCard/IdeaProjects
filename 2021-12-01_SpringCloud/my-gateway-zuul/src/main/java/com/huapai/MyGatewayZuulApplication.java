package com.huapai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
// 启动网关
@EnableZuulProxy
public class MyGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGatewayZuulApplication.class, args);
    }

}
