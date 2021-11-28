package com.huapai.service;

import com.huapai.dao.Test01Dao;
import com.huapai.entity.Test01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private Test01Dao test01Dao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Test01 test01 = test01Dao.selectByUsername(username);
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("");
        if (test01.getIsAdmin()) {
            authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
        } else {
            authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
        }
        return new User(test01.getUsername(),test01.getPassword(),authorityList);
    }
}
