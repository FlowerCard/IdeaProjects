package com.huapai.jedis;

import com.alibaba.fastjson.JSON;
import com.huapai.constant.RedisConstant;
import com.huapai.entity.Student;
import com.huapai.util.JedisUtil;
import com.huapai.util.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
public class TestJedis {

    /**
     * 使用 String 存储，把对象的属性和属性值作为键和值
     */
    @Test
    public void testStringKeyValue() throws IllegalAccessException {
        Student student = new Student(1004L,"test02",20);
        Jedis jedis = JedisUtil.getResource();
        Field[] fields = student.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(jedis.set(field.getName(), String.valueOf(field.get(student))));
        }
    }

    /**
     * 使用对象转成 JSON 字符串进行存储
     */
    @Test
    public void testStringJson() {
        Student student = new Student(1003L,"test02",20);
        String jsonString = JSON.toJSONString(student);
        Jedis jedis = JedisUtil.getResource();
        String redisKey = RedisUtil.createRedisKey(RedisConstant.STUDENT_PREFIX, student.getId().toString());
        System.out.println(jedis.set(redisKey, jsonString));
    }

    /**
     * 反射自动加载类中数据
     * @throws IllegalAccessException
     */
    @Test
    public void testHash02() throws IllegalAccessException {
        Student student = new Student(1002L,"test02",20);
        Jedis jedis = JedisUtil.getResource();
        String redisKey = RedisUtil.createRedisKey(RedisConstant.STUDENT_PREFIX, student.getId().toString());
        Field[] fields = student.getClass().getDeclaredFields();
        Map<String ,String > map = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), String.valueOf(field.get(student)));
        }
        System.out.println(jedis.hmset(redisKey, map));
    }

    /**
     * 使用 Hash 存对象
     */
    @Test
    public void testHash01() {
        Student student = new Student(1001L,"test01",20);
        Jedis jedis = JedisUtil.getResource();
        // 获取 Redis Key
        String redisKey = RedisUtil.createRedisKey(RedisConstant.STUDENT_PREFIX, student.getId().toString());
        // 封装属性值
        Map<String ,String > map = new HashMap<>();
        map.put("name",student.getName());
        map.put("age",String.valueOf(student.getAge()));
        System.out.println(jedis.hmset(redisKey, map));
        
    }

    /**
     * 使用 jedis 连接 Redis
     */
    @Test
    public void testJedis() {
        String host = "192.168.148.138";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        jedis.set("myTest01","123123123123");
        System.out.println(jedis.get("myTest01"));
        jedis.close();
    }

    /**
     * 使用连接池
     */
    @Test
    public void testJedisPool() {
        Jedis jedis = JedisUtil.getResource();
        jedis.set("myTest02","fdfsdfadfadf");
        System.out.println(jedis.get("myTest02"));
    }
    
}
