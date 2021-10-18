package com.huapai.config;

import com.huapai.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/18.
 * 用户详细信息
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private IUserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        String pwd = passwordEncoder.encode("112233");
        
        //根据用户名查询用户信息
        com.huapai.entity.User selectUser = userDao.selectByUsername(username);

        List<GrantedAuthority> authorityList = null;
        if (selectUser != null) {
            pwd = passwordEncoder.encode(selectUser.getPassword());
            if ("manager".equalsIgnoreCase(selectUser.getRole())) {
                authorityList = AuthorityUtils.createAuthorityList("ROLE_manager");
            } else if ("employee".equalsIgnoreCase(selectUser.getRole())) {
                authorityList = AuthorityUtils.createAuthorityList("ROLE_employee");
            }

            /*if ("user_query".equalsIgnoreCase(selectUser.getAuth())) {
                authorityList = AuthorityUtils.createAuthorityList("user_query");
            } else if ("user_add".equalsIgnoreCase(selectUser.getAuth())) {
                authorityList = AuthorityUtils.createAuthorityList("user_add");
            }*/
        }
                
        return new User(username, pwd, authorityList);
    }
}
