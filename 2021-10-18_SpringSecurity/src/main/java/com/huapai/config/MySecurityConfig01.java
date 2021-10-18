package com.huapai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/18.
 * 自定义验证的规则
 */
@Configuration
public class MySecurityConfig01 extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;
    
    @Bean
    RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        String hierarchy = "ROLE_employee < ROLE_manager";
        String hierarchy = "ROLE_manager > ROLE_employee";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String pwd = passwordEncoder.encode("sanzhang");
//        auth.inMemoryAuthentication()
//                .withUser("zhangsan")
//                .password(pwd)
//                .roles();
        auth.userDetailsService(userDetailsService);
    }

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        *//** 登录页面和认证设置
         http
         //登录表单
         .formLogin()
         //登录的页面
         .loginPage("/login.html")
         //验证登录的handler
         .loginProcessingUrl("/users/login")
         //成功后，默认跳转的页面
         .defaultSuccessUrl("/index.html")
         //此项设置后最后一个的方法，表示放行
         .permitAll()
         .and()
         //授权请求
         .authorizeRequests()
         //任何请求都要经过验证 —— 除非声明了不拦截
         .anyRequest()
         //和permitAll相反，全部认证
         .authenticated()
         .and()
         //跨域请求拦截
         .csrf()
         //关闭
         .disable();*//*

        *//**
         * 基于角色进行认证控制
         * 基于用户权限进行访问控制
         *//*
        http
                //登录表单
                .formLogin()
                //登录的页面
                .loginPage("/login.html")
                //验证登录的handler
                .loginProcessingUrl("/users/login")
                //成功后，默认跳转的页面
                .defaultSuccessUrl("/index.html")
                //此项设置后最后一个的方法，表示放行
                .permitAll()
                .and()
                //授权请求
                .authorizeRequests()

                //基于角色进行认证控制
                .antMatchers("/users/getUser01").hasRole("employee")
                .antMatchers("/users/getUser02").hasRole("manager")
                .antMatchers("/users/getUser03").hasAnyRole("employee,manager")
                
                //基于用户权限进行访问控制
                .antMatchers("/users/getUser04").hasAuthority("user_add")
                .antMatchers("/users/getUser05").hasAuthority("user_query")
                .antMatchers("/users/getUser06").hasAnyAuthority("user_add,user_query")

                .and()
                //授权请求
                .authorizeRequests()
                //任何请求都要经过验证 —— 除非声明了不拦截
                .anyRequest()
                //和permitAll相反，全部认证
                .authenticated()
                .and()
                //跨域请求拦截
                .csrf()
                //关闭
                .disable();
    }*/
}
