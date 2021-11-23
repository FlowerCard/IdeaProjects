package com.huapai.consumer;

import com.huapai.api.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@EnableAutoConfiguration
public class AsyncDubboConsumer {
    
    @Reference(version = "async")
    private SiteService service;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AsyncDubboConsumer.class);
        SiteService siteService = context.getBean(SiteService.class);
        // 调用异步方法
        CompletableFuture<String> future = siteService.siteNameAsync("huapai-async-face");
        // 设置监听，非阻塞
        future.whenComplete((v, e) -> {
            if (e != null) {
                e.printStackTrace();
            } else {
                System.out.println("result: " + v);
            }
        });
        System.out.println("异步调用结束");
    }
    
}
