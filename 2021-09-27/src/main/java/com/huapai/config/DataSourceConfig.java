package com.huapai.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Configuration
@PropertySource("classpath:druid.properties")
public class DataSourceConfig {
    
    @Value("${driverClassName}")
    private String driverClassName;
    
    @Value("${druid.url}")
    private String url;
    
    @Value("${druid.username}")
    private String username;
    
    @Value("${druid.password}")
    private String password;
    
    @Bean
    public DataSource  dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
