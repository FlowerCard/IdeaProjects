package com.huapai.config;

import com.huapai.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 * HTTP摘要认证
 */
@EnableWebSecurity(debug = true)
public class SecurityConfig03 extends WebSecurityConfigurerAdapter {

    /**
     * 配置摘要认证入口端点
     */
    @Autowired
    @Lazy
    private DigestAuthenticationEntryPoint digestAuthenticationEntryPoint;
    
    @Autowired
    private MyUserDetailsService userDetailsService;

    //配置认证入口端点，主要是设置认证参数信息
    @Bean
    public DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
        DigestAuthenticationEntryPoint point = new DigestAuthenticationEntryPoint();
        point.setKey("Security Demos");
        point.setRealmName("huapai");
        point.setNonceValiditySeconds(500);
        return point;
    }
    
    public DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter filter = new DigestAuthenticationFilter();
        filter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
        filter.setUserDetailsService(userDetailsService);
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .hasRole("USER")
                .antMatchers("/visitor/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                // 当未认证时访问某些资源，则由该认证入口类来处理
                .exceptionHandling()
                .authenticationEntryPoint(digestAuthenticationEntryPoint)
                .and()
                // 添加自定义过滤器到过滤器链中
                .addFilter(digestAuthenticationFilter());
    }
}
