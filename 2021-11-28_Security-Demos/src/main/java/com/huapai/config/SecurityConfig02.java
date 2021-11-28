package com.huapai.config;

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
public class SecurityConfig02 extends WebSecurityConfigurerAdapter {

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
        // 进一步配置自定义的登录页
        // 拦截请求，创建 FilterSecurityInterceptor
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                //用 and 来表示配置过滤器结束，以便进行下一个过滤器的创建和配置
                .and()
                // 使用表单登录，创建 UsernamePasswordAuthorizationFilter
                .formLogin()
                .loginPage("/myLogin.html")
                .permitAll()
                // 指登录成功后，是否跳转到登录成功URL。默认为 false
                .defaultSuccessUrl("/index.html",true)
                // post 登录接口，登录验证由系统实现
                .loginProcessingUrl("/login")
                // 用户名密码错误跳转接口
                .failureUrl("/error.html")
                // 要认证的用户参数名，默认为 username
                .usernameParameter("username")
                // 要认证的密码参数名，默认为 password
                .passwordParameter("password")
                .and()
                // 配置注销
                .logout()
                // 注销成功后跳转到的接口
                .logoutSuccessUrl("/myLogin.html")
                .permitAll()
                // 删除自定义的 cookie
                .deleteCookies("myCookie")
                .and()
                // 注意：需禁用 csrf 防护功能，否则登录不成功
                .csrf()
                .disable();
    }
}
