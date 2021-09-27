package com.huapai.dao;

import com.huapai.pojo.Hero;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
public interface IHeroDao {
    Hero selectById(Integer id);
}
