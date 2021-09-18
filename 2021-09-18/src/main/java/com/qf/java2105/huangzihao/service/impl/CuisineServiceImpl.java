package com.qf.java2105.huangzihao.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.ICuisineDao;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Cuisine;
import com.qf.java2105.huangzihao.service.ICuisineService;
import com.qf.java2105.huangzihao.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜系业务层实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class CuisineServiceImpl implements ICuisineService {
    
    private ICuisineDao cuisineDao = (ICuisineDao) BeanFacotry.getBean("cuisineDao");
    
    /**
     * 通过菜系名称查询
     *
     * @param cuisineName 菜系名称
     * @return
     */
    @Override
    public ResultVO queryByName(String cuisineName) {

        try {
            //处理字符串
            if (StringUtils.isEmpty(cuisineName)) {
                cuisineName = "%%";
            } else {
                cuisineName = "%" + cuisineName.trim() + "%";
            }

            //调用Dao层
            List<Cuisine> cuisineList = cuisineDao.queryByName(cuisineName);
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,cuisineList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL,e.getMessage());
        }
    }

    /**
     * 通过菜系ID查询
     *
     * @param cuisineId 菜系ID
     * @return
     */
    @Override
    public ResultVO<Cuisine> queryById(Integer cuisineId) {
        try {
            Cuisine cuisine = cuisineDao.queryById(cuisineId);
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS,cuisine);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.QUERY_FAIL);
        }
    }

    /**
     * 通过菜系id修改菜系名称
     *  @param cuisineId   菜系id
     * @param cuisineName 菜系名称
     * @param userId      用户id
     * @return
     */
    @Override
    public ResultVO<String> updateById(Integer cuisineId, String cuisineName, Integer userId) {
        try {
            //开始事务
            JdbcUtil.begin();
            cuisineDao.updateById(cuisineId, cuisineName, userId);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.UPDATE_FAIL);
        }
    }

    /**
     * 通过菜系ID删除
     *
     * @param cuisineId 菜系ID
     * @return
     */
    @Override
    public ResultVO<String> deleteById(Integer cuisineId) {
        try {
            JdbcUtil.begin();
            cuisineDao.deleteById(cuisineId);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.ok(MessageConstant.DELETE_FAIL);
        }
    }

    /**
     * 新增菜系
     *
     * @param cuisine 菜系对象
     * @return
     */
    @Override
    public ResultVO<String> save(Cuisine cuisine) {
        try {
            JdbcUtil.begin();
            Integer deleteStatus = cuisineDao.queryDeleteStatus(cuisine.getCuisineName());
            if (null != deleteStatus) {
                cuisineDao.updateCuisineStatus(deleteStatus);
            } else {
                cuisineDao.save(cuisine);
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
     * 判断菜系名字是否存在
     *
     * @param cuisineName 菜系名字
     * @return
     */
    @Override
    public ResultVO existsCuisineName(String cuisineName) {
        try {
            Integer cuisineId = cuisineDao.existsCuisineName(cuisineName);
            //如果有数据
            if (null != cuisineId) {
                return ResultVO.error(MessageConstant.EXITIS_NAME);
            } else {
                return ResultVO.ok(MessageConstant.UNEXITIS_NAME);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
        }
        return ResultVO.error(MessageConstant.EXITIS_NAME);
    }
}
