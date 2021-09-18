package com.qf.java2105.huangzihao.service.impl;

import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.entity.PageBean;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IFrontService;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public class FrontServiceImpl implements IFrontService {
    
    private IDishesDao dishesDao = (IDishesDao) BeanFacotry.getBean("dishesDao");
    
    /**
     * 条件分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @param cuisineId   菜系ID
     * @param dishesName  菜品名称
     * @return
     */
    @Override
    public ResultVO<PageBean<Dishes>> queryByPage(Integer currentPage, Integer pageSize, Integer cuisineId, String dishesName) {
        try {
            PageBean<Dishes> pageBean = new PageBean<>();
            //设置页大小
            pageBean.setPageSize(pageSize);
            //获取总数
            Long count = dishesDao.countByCondition(cuisineId, dishesName);
            //设置总数量
            pageBean.setTotalCount(count);
            //设置总页数
            pageBean.setTotalPage();
            //设置当前页
            pageBean.setCurrentPage(currentPage);
            //分页查询
            /*
                设置起始位置
                第一页，页大小为6 。 ：(1-1)*6 = 0
                第二页，页大小为6 。 ：(2-1)*6 = 6
             */
            Integer start = (pageBean.getCurrentPage() - 1) * pageBean.getPageSize();
            if (start < 0) {
                start = 0;
            }
            //查询条数
            Integer end = pageBean.getPageSize();
            List<Dishes> dishesList = dishesDao.queryByPage(start, end, cuisineId, dishesName);
            //设置当前页集合
            pageBean.setBeanList(dishesList);

            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL);
        }
    }
}
