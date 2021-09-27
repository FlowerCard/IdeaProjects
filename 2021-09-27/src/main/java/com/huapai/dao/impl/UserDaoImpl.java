package com.huapai.dao.impl;

import com.huapai.dao.IUserDao;
import com.huapai.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
//Dao层使用的Spring注解，可以在后面添加()输入类的别名，方便在Dao有多个实现类时进行创建以及管理
//@Repository("别名")
@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public User selectUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("test" + id);
        return user;
    }
}
