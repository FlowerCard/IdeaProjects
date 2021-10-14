package com.huapai.service;

import com.huapai.entity.GoodsType;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品类型业务层接口
 */
public interface IGoodsTypeService {

    /**
     * 查询所有商品类型
     * @return 商品类型集合
     */
    public List<GoodsType> searchAll();

    /**
     * 通过ID查询
     * @param id 商品类型ID
     * @return 商品类型对象
     */
    public GoodsType searchById(Integer id);

    /**
     * 类型id是否存在
     * @param typeId 类型id
     * @return 是否存在
     */
    public Boolean existTypeId(Integer typeId);

    /**
     * 添加商品类型
     * @param goodsType 商品类型对象
     */
    public void addGoodsType(GoodsType goodsType);

    /**
     * 修改商品类型
     * @param goodsType 商品类型对象
     */
    public void modifyGoodsType(GoodsType goodsType);

    /**
     * 通过ID删除
     * @param id ID
     */
    public Boolean removeGoodsType(Integer id);
    
}
