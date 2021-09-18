package com.qf.java2105.huangzihao.service;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Dishes;

import java.util.List;

/**
 * 菜品业务层接口
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public interface IDishesService {

    /**
     * 通过名字查询
     *
     * @param dishName 磁盘名字
     * @return
     */
    public ResultVO<List<Dishes>> queryByName(String dishName);

    /**
     * 新增菜品
     *
     * @param dishes 菜品对象
     * @return
     */
    public ResultVO<String> save(Dishes dishes);

    /**
     * 通过ID查询
     *
     * @param dishesId 菜品ID
     * @return
     */
    public ResultVO<Dishes> queryById(Integer dishesId);

    /**
     * 更新菜品
     * @param dishes 菜品实体
     * @return
     */
    public ResultVO<String> updateById(Dishes dishes);

    /**
     * 通过id删除
     * @param dishesId 菜品id
     * @return
     */
    public ResultVO<String> deleteById(Integer dishesId);

    /**
     * 判断菜品名字是否存在
     * @param dishesName 菜品名字
     * @return
     */
    public ResultVO existsDishesName(String dishesName);

}
