package com.huapai.dao;

import com.huapai.entity.Worksite;

public interface WorksiteDao {
    int deleteByPrimaryKey(Integer workId);

    int insert(Worksite record);

    int insertSelective(Worksite record);

    Worksite selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(Worksite record);

    int updateByPrimaryKey(Worksite record);
}