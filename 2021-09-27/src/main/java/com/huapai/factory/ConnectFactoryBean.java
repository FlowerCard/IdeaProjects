package com.huapai.factory;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 连接工厂
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
public class ConnectFactoryBean implements FactoryBean<Connection> {
    @Override
    public Connection getObject() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2105db", "root", "root");
        return connection;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    /**
     * 是否单例模式创建
     * 为保证每个创建的连接都是单独隔离的。
     * 使用多例模式创建实例
     * @return 布尔值
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
