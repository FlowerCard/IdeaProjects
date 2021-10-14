package com.huapai.service.impl;

import com.huapai.dao.IGoodsDao;
import com.huapai.dao.IGoodsTypeDao;
import com.huapai.entity.Goods;
import com.huapai.entity.GoodsType;
import com.huapai.service.IGoodsTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品类型业务层实现类
 */
@Service("goodsTypeService")
@Transactional
public class GoodsTypeServiceImpl implements IGoodsTypeService {
    
    @Resource
    private IGoodsTypeDao goodsTypeDao;
    
    @Resource
    private IGoodsDao goodsDao;
    
    @Override
    public List<GoodsType> searchAll() {
        return goodsTypeDao.selectAll();
    }

    @Override
    public GoodsType searchById(Integer id) {
        return goodsTypeDao.selectById(id);
    }

    @Override
    public Boolean existTypeId(Integer typeId) {
        Integer searchByTypeId = goodsTypeDao.searchByTypeId(typeId);
        return searchByTypeId == null;
    }

    @Override
    public void addGoodsType(GoodsType goodsType) {
        goodsTypeDao.insertGoodsType(goodsType);
    }

    @Override
    public void modifyGoodsType(GoodsType goodsType) {
        //查商品类型下有没有子项
        GoodsType beforeType = goodsTypeDao.selectById(goodsType.getId());
        Integer row = goodsTypeDao.hasItem(beforeType.getTypeId());
        //如果子项就把子项的产品类型ID一起修改掉
        if (row != 0) {
            List<Integer> goodsIdList = goodsDao.searchByTypeId(beforeType.getTypeId());
            List<Goods> goodsList = new ArrayList<>();
            //把对应的商品ID查出来
            for (Integer goodId : goodsIdList) {
                Goods goods = goodsDao.selectById(goodId);
                //修改每个ID对应的商品并放入集合
                goods.setGoodsType(goodsType.getTypeId());
                goodsList.add(goods);
            }
            for (Goods goods : goodsList) {
                goodsDao.updateGoods(goods);
            }
        goodsTypeDao.updateGoodsType(goodsType);
        }
    }

    @Override
    public Boolean removeGoodsType(Integer id) {
        //先查出商品类型对象
        GoodsType goodsType = goodsTypeDao.selectById(id);
        //再查商品类型下有没有子项
        Integer row = goodsTypeDao.hasItem(goodsType.getTypeId());
        //如果有子项就结束
        if (row == 0) {
            //没有子项就执行删除操作
            goodsTypeDao.deleteById(id);
            return true;
        }
        return false;
    }
}
