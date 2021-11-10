package com.huapai.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 * Jedis 工具类
 * 使用 Jedis 连接池
 */
public class JedisUtil {

    /**
     * 主机地址
     */
    private static String host;
    /**
     * 主机端口
     */
    private static Integer port;
    /**
     * 登录密码
     */
    private static String password;
    /**
     * 连接池配置
     */
    private static GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
    /**
     * 连接池对象
     */
    private static JedisPool jedisPool;
    
    static {
        
        host = "192.168.148.138";
        port = 6379;
        password = "admin";
        
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(5);
        poolConfig.setMaxWaitMillis(3000);
        
        jedisPool = new JedisPool(poolConfig,host,port,3000,password);
    }

    /**
     * 
     * @return 获取连接池中的 Jedis
     */
    public static Jedis getResource() {
        return jedisPool.getResource();
    }
    
}
