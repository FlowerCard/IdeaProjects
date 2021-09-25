package com.qf.java2105.huangzihao.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IDishesService;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import com.qf.java2105.huangzihao.utils.MybatisUtil;

import java.sql.SQLException;
import java.util.List;

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
            dishesDao = MybatisUtil.getMapper(IDishesDao.class);
            //判断传入的用户是否为空
            if (StringUtils.isEmpty(dishName)) {
                dishName = "%%";
            } else {
                dishName = "%" + dishName.trim() + "%";
            }
            List<Dishes> dishList = dishesDao.queryByName(dishName);
            return ResultVO.ok(MessageConstant.QUERY_SUCCESS, dishList);
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
            dishesDao = MybatisUtil.getMapper(IDishesDao.class);
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
            MybatisUtil.commit();
            return ResultVO.ok(MessageConstant.INSERT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.rollback();
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
            dishesDao = MybatisUtil.getMapper(IDishesDao.class);
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
            dishesDao = MybatisUtil.getMapper(IDishesDao.class);
            dishesDao.updateById(dishes);
            MybatisUtil.commit();
            return ResultVO.ok(MessageConstant.UPDATE_SUCCESS);
        } catch (SQLException e) {
            e.printStackTrace();
            MybatisUtil.rollback();
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
            dishesDao = MybatisUtil.getMapper(IDishesDao.class);
            dishesDao.deleteById(dishesId);
            MybatisUtil.commit();
            return ResultVO.ok(MessageConstant.DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.rollback();
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
            dishesDao = MybatisUtil.getMapper(IDishesDao.class);
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
