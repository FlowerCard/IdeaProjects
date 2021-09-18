package com.qf.java2105.huangzihao.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Cuisine;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.utils.JdbcUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 菜品业务层实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class DishesServiceImpl implements IDishesService {
    
    private IDishesDao dishesDao = (IDishesDao) BeanFacotry.getBean("dishesDao");
    
    /**
     * 通过名字查询
     *
     * @param dishName 磁盘名字
     * @return
     */
    @Override
    public ResultVO<List<Dishes>> queryByName(String dishName) {

        try {
            //判断传入的用户是否为空
            if (StringUtils.isEmpty(dishName)) {
                dishName = "%%";
            } else {
                dishName = "%" + dishName.trim() + "%";
            }
            List<Map<String, Object>> dishNameList = dishesDao.queryByName(dishName);
            
            //处理数据
            List<Dishes> dishesList = new ArrayList<>();
            for (Map<String, Object> map : dishNameList) {
                Integer dishesId = (Integer) map.get("dishesId");
                Integer cuisineId = (Integer) map.get("cuisineId");
                String dishesName = (String) map.get("dishesName");
                BigDecimal dishesPrice = (BigDecimal) map.get("dishesPrice");
                BigDecimal dishesMemberPrice = (BigDecimal) map.get("dishesMemberPrice");
                String dishesImg = (String) map.get("dishesImg");
                String dishesIntroduction = (String) map.get("dishesIntroduction");
                Integer dishesStatus = (Integer) map.get("dishesStatus"); 
                String cuisineName = (String) map.get("cuisineName");

                Cuisine cuisine = new Cuisine();
                cuisine.setCuisineId(cuisineId);
                cuisine.setCuisineName(cuisineName);
                
                Dishes dishes = new Dishes(
                        dishesId,cuisineId,dishesName,dishesPrice,dishesMemberPrice,dishesImg,dishesIntroduction,dishesStatus
                );
                dishes.setCuisine(cuisine);
                dishesList.add(dishes);
            }
            
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,dishesList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL);
        }
    }

    /**
     * 新增菜品
     *
     * @param dishes 菜品对象
     * @return
     */
    @Override
    public ResultVO<String> save(Dishes dishes) {

        try {
            JdbcUtil.begin();
            Integer queryDeleteStatus = dishesDao.queryDeleteStatus(dishes.getDishesName());
            if (null != queryDeleteStatus) {
                //更新删除状态
                dishesDao.updateDishesStatus(queryDeleteStatus);
                //设置菜品ID
                dishes.setDishesId(queryDeleteStatus);
                //更新菜品
                dishesDao.updateById(dishes);
            } else {
                dishesDao.save(dishes);
            }
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.INSERT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.INSERT_FAIL);
        }
    }

    /**
     * 通过ID查询
     *
     * @param dishesId 菜品ID
     * @return
     */
    @Override
    public ResultVO<Dishes> queryById(Integer dishesId) {

        try {
            Dishes dishes = dishesDao.queryById(dishesId);
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,dishes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL);
        }
    }

    /**
     * 更新菜品
     * @param dishes 菜品实体
     * @return
     */
    @Override
    public ResultVO<String> updateById(Dishes dishes) {
        try {
            JdbcUtil.begin();
            dishesDao.updateById(dishes);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.UPDATE_SUCCESS);
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.UPDATE_FAIL);
        }
    }

    /**
     * 通过id删除
     *
     * @param dishesId 菜品id
     * @return
     */
    @Override
    public ResultVO<String> deleteById(Integer dishesId) {

        try {
            JdbcUtil.begin();
            dishesDao.deleteById(dishesId);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.DELETE_FAIL);
        }
    }

    /**
     * 判断菜品名字是否存在
     *
     * @param dishesName 菜品名字
     * @return
     */
    @Override
    public ResultVO existsDishesName(String dishesName) {
        try {
            Integer existsDishesName = dishesDao.existsDishesName(dishesName);
            if (null != existsDishesName) {
                return ResultVO.error(MessageConstant.EXITIS_NAME);
            } else {
                return ResultVO.ok(MessageConstant.UNEXITIS_NAME);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.EXITIS_NAME);
    }
}
