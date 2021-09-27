package com.huapai.service.impl;

import com.huapai.pojo.User;
import com.huapai.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User queryUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("test" + id);
        return user;
    }
}
