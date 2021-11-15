package com.huapai.redis.entity.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/15.
 */
@Configuration
public class RedissonConfig {
    
    @Bean
    public Config config() {
        Config config = new Config();
        config.useClusterServers().addNodeAddress("redis://192.168.148.138:7001","redis://192.168.148.138:7002","redis://192.168.148.138:7003");
        return config;
    }
    
    @Bean
    public RedissonClient redissonClient(Config config) {
        return Redisson.create(config);
    }
    
}
