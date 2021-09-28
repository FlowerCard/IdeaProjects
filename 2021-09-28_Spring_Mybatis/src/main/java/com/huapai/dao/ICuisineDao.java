package com.huapai.dao;

import com.huapai.pojo.Cuisine;
import org.springframework.stereotype.Repository;

@Repository("cuisineDao")
public interface ICuisineDao {
    int deleteByPrimaryKey(Integer tCuisineId);

    int insert(Cuisine record);

    int insertSelective(Cuisine record);

    Cuisine selectByPrimaryKey(Integer tCuisineId);

    int updateByPrimaryKeySelective(Cuisine record);

    int updateByPrimaryKey(Cuisine record);
}