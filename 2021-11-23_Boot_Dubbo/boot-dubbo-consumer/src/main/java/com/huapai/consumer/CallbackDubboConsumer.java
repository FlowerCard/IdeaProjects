package com.huapai.consumer;

import com.huapai.api.SiteService;
import com.huapai.api.SiteServiceListenerImpl;
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
public class CallbackDubboConsumer {
    
    @Reference(version = "callback")
    private SiteService siteService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CallbackDubboConsumer.class);
        SiteService bean = context.getBean(SiteService.class);
        System.out.println(bean.siteName("huapai-face","c1",new SiteServiceListenerImpl()));
        System.out.println(bean.siteName("huapai-face","c2",new SiteServiceListenerImpl()));
        System.out.println(bean.siteName("huapai-face","c3",new SiteServiceListenerImpl()));
    }
    
}
