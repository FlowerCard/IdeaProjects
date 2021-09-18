package com.qf.java2105.huangzihao.factory;

import java.util.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/13.
 */
public class OrderedProperties extends Properties {

    private static final long serialVersionUID = 4710927773256743817L;

    private final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();

    @Override
    public Enumeration<Object> keys() {
        return Collections.<Object> enumeration(keys);
    }

    @Override
    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    @Override
    public Set<Object> keySet() {
        return keys;
    }

    /**
     * 返回按照properties文件存储顺序的名称集合
     * @return
     */
    @Override
    public Set<String> stringPropertyNames() {
        Set<String> set = new LinkedHashSet<String>();

        for (Object key : this.keys) {
            set.add((String) key);
        }

        return set;
    }
}
