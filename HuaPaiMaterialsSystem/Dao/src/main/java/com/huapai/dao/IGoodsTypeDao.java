package com.huapai.dao;

import com.huapai.entity.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品类型持久层接口
 */
@Repository("goodsTypeDao")
public interface IGoodsTypeDao {

    /**
     * 查询所有商品类型
     * @return 商品类型集合
     */
    public List<GoodsType> selectAll();

    /**
     * 通过ID查询
     * @param id 商品类型id
     * @return 商品类型
     */
    public GoodsType selectById(Integer id);

    /**
     * 通过typeID查询
     * @param typeId 商品类型id
     * @return 商品类型
     */
    public Integer searchByTypeId(Integer typeId); 

    /**
     * 插入商品类型
     * @param goodsType 商品类型对象
     * @return 受影响行数
     */
    public Integer insertGoodsType(GoodsType goodsType);

    /**
     * 更新商品类型
     * @param goodsType 商品类型对象
     * @return 受影响行数
     */
    public Integer updateGoodsType(GoodsType goodsType);

    /**
     * 通过ID删除
     * @param id ID
     * @return 受影响行数
     */
    public Integer deleteById(Integer id);

    /**
     * 查找是否有子项目
     * @param typeId 商品类型ID
     * @return 商品ID
     */
    public Integer hasItem(Integer typeId);
    
}
