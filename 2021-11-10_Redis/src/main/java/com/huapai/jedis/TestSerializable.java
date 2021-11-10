package com.huapai.jedis;

import com.huapai.constant.RedisConstant;
import com.huapai.entity.Student;
import com.huapai.util.JedisUtil;
import com.huapai.util.RedisUtil;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
public class TestSerializable {

    /**
     * 反序列化
     */
    @Test
    public void testDecodeJavaBean() {
        String redisKey = RedisUtil.createRedisKey(RedisConstant.STUDENT_PREFIX, "1005");

        byte[] key = SerializationUtils.serialize(redisKey);

        Jedis jedis = JedisUtil.getResource();
        byte[] value = jedis.get(key);
        System.out.println(redisKey + "  =====>  " + SerializationUtils.deserialize(value));
    }

    /**
     * 序列化 Java Bean
     */
    @Test
    public void testEncodeJavaBean() {
        Student student = new Student(1005L,"test05",20);

        String redisKey = RedisUtil.createRedisKey(RedisConstant.STUDENT_PREFIX, student.getId().toString());
        byte[] key = SerializationUtils.serialize(redisKey);
        byte[] value = SerializationUtils.serialize(student);

        Jedis jedis = JedisUtil.getResource();
        System.out.println(jedis.set(key, value));
    }
    
}
