package com.huapai.zookeeper.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/16.
 */
@Configuration
public class CuratorConfig {
    
    @Autowired
    private WrapperZK wrapperZK;
    
    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.newClient(
                // 连接地址
                wrapperZK.getConnectString(),
                // 会话超时时间
                wrapperZK.getSessionTimeoutMs(),
                // 连接超时时间
                wrapperZK.getConnectionTimeoutMs(), 
                // 重试配置
                new RetryNTimes(wrapperZK.getRetryCount(), wrapperZK.getElapsedTimeMs())
        );
    }
    
}
