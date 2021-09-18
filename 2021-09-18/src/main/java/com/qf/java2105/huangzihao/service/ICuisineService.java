package com.qf.java2105.huangzihao.service;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Cuisine;

/**
 * 菜系业务层接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public interface ICuisineService {

    /**
     * 通过菜系名称查询
     * @param cuisineName 菜系名称
     * @return
     */
    public ResultVO queryByName(String cuisineName);

    /**
     * 通过菜系ID查询
     * @param cuisineId 菜系ID
     * @return
     */
    public ResultVO<Cuisine> queryById(Integer cuisineId);

    /**
     * 通过菜系id修改菜系名称
     * @param cuisineId 菜系id
     * @param cuisineName 菜系名称
     * @param userId 用户id
     * @return
     */
    public ResultVO<String> updateById(Integer cuisineId,String cuisineName,Integer userId);

    /**
     * 通过菜系ID删除
     * @param cuisineId 菜系ID
     * @return
     */
    public ResultVO<String> deleteById(Integer cuisineId);

    /**
     * 新增菜系
     * @param cuisine 菜系对象
     * @return
     */
    public ResultVO<String> save(Cuisine cuisine);

    /**
     * 判断菜系名字是否存在
     * @param cuisineName 菜系名字
     * @return
     */
    public ResultVO existsCuisineName(String cuisineName);
    
    
}
