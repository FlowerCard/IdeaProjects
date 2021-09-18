package com.qf.java2105.huangzihao.service;

import com.qf.java2105.huangzihao.entity.PageBean;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Dishes;

/**
 * 前台业务层接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public interface IFrontService {

    /**
     * 条件分页查询 
     * @param currentPage 当前页
     * @param pageSize  页大小
     * @param cuisineId 菜系ID
     * @param dishesName 菜品名称
     * @return
     */
    public ResultVO<PageBean<Dishes>> queryByPage(Integer currentPage, Integer pageSize, Integer cuisineId, String dishesName);
    
}
