package com.huapai.service;

import com.huapai.entity.Goods;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品业务层接口
 */
public interface IGoodsService {

    /**
     * 查询所有商品
     * @return 商品集合
     */
    public List<Goods> queryAll();

    /**
     * 通过ID查询
     * @param id 商品id
     * @return 商品对象
     */
    public Goods queryById(Integer id);

    /**
     * 通过名字查询
     * @param goodsName 商品名称
     * @return 对象集合
     */
    public List<Goods> queryByName(String goodsName);

    /**
     * 商品id是否存在
     * @param goodsId 商品id
     * @return 是否存在
     */
    public Boolean existGoodsId(Integer goodsId);

    /**
     * 增加商品
     * @param goods 商品对象
     */
    public void addGoods(Goods goods);

    /**
     * 修稿商品
     * @param goods 商品对象
     */
    public void modifyGoods(Goods goods);

    /**
     * 删除商品
     * @param id 商品id
     */
    public void removeGoods(Integer id);

    /**
     * 商品出库
     * @param id 出库ID
     * @param outNum 出库数量
     */
    public void outGoods(Integer id,Integer outNum,Integer userId);

    /**
     * 商品入库
     * @param id 入库id
     * @param inNum 入库数量
     */
    public void inGoods(Integer id,Integer inNum,Integer userId);
    
}
