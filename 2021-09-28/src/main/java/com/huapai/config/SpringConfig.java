package com.huapai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 */
@Configuration
@ComponentScan("com.huapai")
/**
 * 开启AOP自动代理
 */
@EnableAspectJAutoProxy
public class SpringConfig {
}
