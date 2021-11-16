package com.huapai.zookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/16.
 */
@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class WrapperZK {
    
    private int retryCount;
    
    private int elapsedTimeMs;
    
    private String connectString;
    
    private int sessionTimeoutMs;
    
    private int connectionTimeoutMs;
    
}
