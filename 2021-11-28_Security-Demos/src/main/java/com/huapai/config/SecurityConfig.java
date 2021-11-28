package com.huapai.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 */
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 用来定义哪些请求需要忽略安全控制，哪些请求必须接受安全控制;
     * 还可以在合适的时候清除SecurityContext以避免内存泄漏，
     * 同时也可以用来定义请求防火墙和请求拒绝处理器，另外我们开启Spring Security Debug模式也是这里配置的
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
        web.ignoring()
                .antMatchers("/js/**","/css/**","images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 2.配置自定义的登录页面
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                // 加载自定义的登录页面
                .loginPage("/myLogin.html")
                .permitAll()
                .and()
                // 注意：需禁用 crsf 防护功能，否则登录不成功
                .csrf()
                .disable();
    }
    
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置表单认证方式
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }*/
    
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1.配置基本认证方式
        http.authorizeRequests()
                // 对任意请求都进行认证
                .anyRequest()
                .authenticated()
                .and()
                // 开启basic认证
                .httpBasic();
    }*/
}
