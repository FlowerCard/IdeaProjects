package com.huapai.consumer;

import com.huapai.api.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@EnableAutoConfiguration
public class StubDubboConsumer {
    
    @Reference(version = "timeout", timeout = 1000, stub = "true")
    private SiteService siteService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StubDubboConsumer.class);
        SiteService bean = context.getBean(SiteService.class);
        String siteName = bean.siteName("huapai-face");
        System.out.println("siteName = " + siteName);
    }
    
}
