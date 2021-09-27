package com.huapai.service.impl;

import com.huapai.dao.IHeroDao;
import com.huapai.pojo.Hero;
import com.huapai.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Service
public class HeroServiceImpl implements IHeroService {
    
    @Autowired
    @Qualifier("heroDao002")
    private IHeroDao heroDao;
    
    @Override
    public Hero queryById(Integer id) {
        System.out.println("HeroServiceImpl ---> queryById --->" + id);
        return null;
    }
}
