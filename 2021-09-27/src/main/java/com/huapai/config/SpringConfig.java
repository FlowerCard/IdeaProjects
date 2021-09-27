package com.huapai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring配置类
 * 效果等同  .xml的配置文件
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
//添加为配置类
@Configuration
//添加扫描
@ComponentScan("com.huapai")
@Import(DataSourceConfig.class)
public class SpringConfig {
}
