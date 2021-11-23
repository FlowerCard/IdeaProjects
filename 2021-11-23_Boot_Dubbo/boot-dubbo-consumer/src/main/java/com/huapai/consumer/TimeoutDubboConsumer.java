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
public class TimeoutDubboConsumer {
    
    @Reference(version = "timeout", timeout = 3000)
    private SiteService siteService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TimeoutDubboConsumer.class);
        SiteService contextBean = context.getBean(SiteService.class);
        String siteName = contextBean.siteName("huapai-face");
        System.out.println("siteName = " + siteName);
    }
    
}
