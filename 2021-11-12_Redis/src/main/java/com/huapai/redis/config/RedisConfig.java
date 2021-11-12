package com.huapai.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 * 手动注入自定义序列化器的 RedisTemplate
 */
@Configuration
public class RedisConfig {
    
    @Bean
    public RedisTemplate<String ,Object> stringObjectRedisTemplate(RedisConnectionFactory factory) {
        // 1.创建 RedisTemplate 对象
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 2.关联工厂
        redisTemplate.setConnectionFactory(factory);
        // 3.设置 key 的序列化器是String
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 4.输入到容器中
        return redisTemplate;
    }
    
}
