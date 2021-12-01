package com.huapai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@SpringBootApplication
public class MyUserConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MyUserConsumer.class,args);
    }
}
