package com.huapai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@SpringBootApplication
@EnableEurekaServer
public class MyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyEurekaApplication.class,args);
    }
    
}
