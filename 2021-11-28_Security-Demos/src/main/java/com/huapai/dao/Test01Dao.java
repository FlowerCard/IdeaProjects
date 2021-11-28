package com.huapai.dao;

import com.huapai.entity.Test01;
import org.springframework.stereotype.Repository;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 */
@Repository(value = "test01Dao")
public interface Test01Dao {
    int deleteByPrimaryKey(Integer id);

    int insert(Test01 record);

    int insertSelective(Test01 record);

    Test01 selectByPrimaryKey(Integer id);

    Test01 selectByUsername(String username);

    int updateByPrimaryKeySelective(Test01 record);

    int updateByPrimaryKey(Test01 record);
}