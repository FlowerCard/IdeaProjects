package com.huapi.redis.util;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
public class RedisUtil {

    /**
     * 创建 Redis Key
     * @param prefix 前缀
     * @param str 内容
     * @return RedisKey
     */
    public static String createRedisKey(String prefix,String ... str) {
        StringBuilder buffer = new StringBuilder(prefix);
        for (String s : str) {
            buffer.append(s);
        }
        return buffer.toString();
    }
    
}
