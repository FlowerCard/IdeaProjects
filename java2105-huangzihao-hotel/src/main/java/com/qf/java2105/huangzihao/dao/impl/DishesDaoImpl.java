package com.qf.java2105.huangzihao.dao.impl;

import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 菜品持久层实现
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class DishesDaoImpl implements IDishesDao {

    private QueryRunner queryRunner = null;

    /**
     * 通过菜品名称查询
     *
     * @param dishName 菜品名称
     * @return 查询集合
     */
//    @Override
//    public List<Map<String, Object>> queryByName(String dishName) throws SQLException {
//        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
//        String sql = "select \n" +
//                "    d.t_dishes_id dishesId,\n" +
//                "    d.t_cuisine_id cuisineId, \n" +
//                "    d.t_dishes_name dishesName, \n" +
//                "    d.t_dishes_price dishesPrice, \n" +
//                "    d.t_dishes_member_price dishesMemberPrice, \n" +
//                "    d.t_dishes_img dishesImg, \n" +
//                "    d.t_dishes_introduction dishesIntroduction, \n" +
//                "    d.t_dishes_status dishesStatus, \n" +
//                "    c.t_cuisine_name cuisineName\n" +
//                "from t_dishes d,t_cuisine c \n" +
//                "where d.t_cuisine_id = c.t_cuisine_id\n" +
//                "and d.t_dishes_status != 3 and d.t_dishes_name like ?";
//        return queryRunner.query(sql, new MapListHandler(), dishName);
//    }

    /**
     * 通过菜品名称查询
     *
     * @param dishName 菜品名称
     * @return 查询集合
     */
    @Override
    public List<Dishes> queryByName(String dishName) throws SQLException {
        return null;
    }

    /**
     * 新增菜品
     *
     * @param dishes 菜品对象
     * @throws SQLException
     */
    @Override
    public void save(Dishes dishes) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into t_dishes (t_cuisine_id, t_dishes_name, t_dishes_price, t_dishes_member_price," +
                " t_dishes_img, t_dishes_introduction) VALUES (?,?,?,?,?,?)";
        queryRunner.update(
                sql,
                dishes.getCuisineId(), dishes.getDishesName(), dishes.getDishesPrice(), dishes.getDishesMemberPrice(),
                dishes.getDishesImg(), dishes.getDishesIntroduction()
        );
    }

    /**
     * 通过ID查询
     *
     * @param dishesId 菜品id
     * @return 菜品对象
     * @throws SQLException
     */
    @Override
    public Dishes queryById(Integer dishesId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select \n" +
                "t_dishes_id dishesId,\n" +
                "t_cuisine_id cuisineId, \n" +
                "t_dishes_name dishesName, \n" +
                "t_dishes_price dishesPrice,\n" +
                "t_dishes_member_price dishesMemberPrice,\n" +
                "t_dishes_img dishesImg, \n" +
                "t_dishes_introduction dishesIntroduction, \n" +
                "t_dishes_status dishesStatus\n" +
                "from t_dishes\n" +
                "where t_dishes_id = ?";
        return queryRunner.query(sql, new BeanHandler<>(Dishes.class), dishesId);
    }

    /**
     * 更新菜品
     *
     * @param dishes 菜品对象
     * @throws SQLException
     */
    @Override
    public void updateById(Dishes dishes) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_dishes\n" +
                "        set t_cuisine_id = ?,t_dishes_name = ?,t_dishes_price = ?," +
                "t_dishes_member_price = ?,t_dishes_img = ?,t_dishes_introduction = ?\n" +
                "        where t_dishes_id = ?";
        queryRunner.update(
                sql,
                dishes.getCuisineId(),dishes.getDishesName(),dishes.getDishesPrice(),dishes.getDishesMemberPrice(),
                dishes.getDishesImg(),dishes.getDishesIntroduction(),dishes.getDishesId()
        );
    }

    /**
     * 根据id删除
     *
     * @param dishesId 菜品id
     * @throws SQLException
     */
    @Override
    public void deleteById(Integer dishesId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_dishes set t_dishes_status = 3 where t_dishes_id = ?";
        queryRunner.update(sql,dishesId);
    }

    /**
     * 查看菜品名字是否存在
     *
     * @param dishesName 菜品名称
     * @return
     */
    @Override
    public Integer existsDishesName(String dishesName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select t_dishes_id from t_dishes where t_dishes_status !=3 and t_dishes_name = ? limit 1";
        return queryRunner.query(sql,new ScalarHandler<>(),dishesName);
    }

    /**
     * 更新菜品是否被删除
     * 配合菜品名称是否存在使用
     * 如果存在，但是被打上了删除状态，就把状态复原到可用
     *
     * @param dishesId 菜品ID
     */
    @Override
    public void updateDishesStatus(Integer dishesId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_dishes set t_dishes_status = 1 where t_dishes_id = ?";
        queryRunner.update(sql,dishesId);
    }

    /**
     * 查询被打上删除标记的菜品
     *
     * @param cuisineName 菜品名称
     * @return
     * @throws SQLException
     */
    @Override
    public Integer queryDeleteStatus(String cuisineName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select t_dishes_id from t_dishes where t_dishes_name = ? and t_dishes_status = 3";
        return queryRunner.query(sql,new ScalarHandler<>(),cuisineName);
    }

    /**
     * 条件总数量
     *
     * @param cuisineId  菜系id
     * @param dishesName 菜品名称
     * @return
     */
    @Override
    public Long countByCondition(Integer cuisineId, String dishesName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        StringBuffer sql = new StringBuffer("select count(1) from t_dishes where 1=1 and t_dishes_status != 3 ");
        List<Object> params = new ArrayList<>();
        //追加模糊查询名字进行分页
        sql.append(" and t_dishes_name like ? ");
        params.add(dishesName);
        if (0 != cuisineId) {
            //菜系ID不为0 追加菜系ID分页查询
            sql.append(" and t_cuisine_id = ? ");
            params.add(cuisineId);
        }
        return queryRunner.query(sql.toString(),new ScalarHandler<>(),params.toArray());
    }

    /**
     * 条件分页查询 
     * @param begin 起始位置
     * @param end 结束位置
     * @param cuisineId 菜系ID
     * @param dishesName 菜系名称
     * @return
     */
    @Override
    public List<Dishes> queryByPage(Integer begin, Integer end, Integer cuisineId, String dishesName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        List<Object> params = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select \n" +
                "t_dishes_id dishesId, \n" +
                "t_cuisine_id cuisineId, \n" +
                "t_dishes_name dishesName, \n" +
                "t_dishes_price dishesPrice, \n" +
                "t_dishes_member_price dishesMemberPrice, \n" +
                "t_dishes_img dishesImg, \n" +
                "t_dishes_introduction dishesIntroduction, \n" +
                "t_dishes_status dishesStatus \n" +
                "from t_dishes where 1=1 and t_dishes_status != 3 ");
        //名字模糊查询
        sql.append(" and t_dishes_name like ? ");
        params.add(dishesName);
        if (0 != cuisineId) {
            //菜系ID不为零 追加根据菜系ID查询
            sql.append(" and t_cuisine_id = ? ");
            params.add(cuisineId);
        }
        //分页查询
        sql.append(" limit ?,? ");
        params.add(begin);
        params.add(end);
        return queryRunner.query(sql.toString(),new BeanListHandler<>(Dishes.class), params.toArray());
    }
}
