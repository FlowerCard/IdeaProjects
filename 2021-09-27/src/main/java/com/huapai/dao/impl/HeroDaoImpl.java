package com.huapai.dao.impl;

import com.huapai.dao.IHeroDao;
import com.huapai.pojo.Hero;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Repository("heroDao")
public class HeroDaoImpl implements IHeroDao {
    
    //通过bean的名字查找对象并注入
    //也可以指定对象的名字 @Resource(name = "hero")
    @Resource
    private Hero hero;
    
    @Override
    public Hero selectById(Integer id) {
        System.out.println("HeroDaoImpl ----> hero --->" + hero);
        return null;
    }
}
