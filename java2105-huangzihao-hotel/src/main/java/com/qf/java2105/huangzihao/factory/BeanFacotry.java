package com.qf.java2105.huangzihao.factory;

import com.alibaba.druid.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 工厂模式
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/13.
 */
public class BeanFacotry {
    
    private static final Properties PROPERTIES = new OrderedProperties();

    /**
     * 实例容器
     */
    private static Map<String ,Object> bean = new HashMap<>();
    
    //加载时，往容器里实例
    static {
        try {
            PROPERTIES.load(BeanFacotry.class.getClassLoader().getResourceAsStream("bean.properties"));
            Set<String> propertyNames = PROPERTIES.stringPropertyNames();
            for (String propertyName : propertyNames) {
                //获取Value
                String property = PROPERTIES.getProperty(propertyName);
                if (!StringUtils.isEmpty(property)) {
                    //反射创建实例
                    Class<?> clazz = Class.forName(property);
                    Object newInstance = clazz.newInstance();
                    bean.put(propertyName,newInstance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取实例
     * @param beanName 实例名
     * @return 实例
     */
    public static Object getBean(String beanName){
        return bean.get(beanName);
    }
    
}
