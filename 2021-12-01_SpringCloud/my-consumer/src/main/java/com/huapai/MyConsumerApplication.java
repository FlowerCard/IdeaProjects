package com.huapai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@SpringBootApplication
@EnableHystrix
public class MyConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyConsumerApplication.class,args);
    }
}
