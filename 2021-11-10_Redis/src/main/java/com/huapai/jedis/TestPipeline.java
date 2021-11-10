package com.huapai.jedis;

import com.huapai.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
public class TestPipeline {

    /**
     * 使用管道之后
     */
    @Test
    public void testPipeline() {
        Jedis jedis = JedisUtil.getResource();
        long start = System.currentTimeMillis();

        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 10000; i++) {
            pipeline.set("pk" + i,"pv" + i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    /**
     * 使用管道之前
     */
    @Test
    public void testMultiSet() {
        Jedis jedis = JedisUtil.getResource();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            jedis.set("k" + i,"v" + i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    
}
