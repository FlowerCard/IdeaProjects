package com.huapai.service.impl;

import com.huapai.dao.IGoodsDao;
import com.huapai.dao.IRecordDao;
import com.huapai.entity.Goods;
import com.huapai.entity.Record;
import com.huapai.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品业务层实现类
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements IGoodsService {
    
    @Resource
    private IGoodsDao goodsDao;
    
    @Resource
    private IRecordDao recordDao;
    
    @Resource
    private Record record;
    
    @Override
    public List<Goods> queryAll() {
        return goodsDao.selectAll();
    }

    @Override
    public Goods queryById(Integer id) {
        return goodsDao.selectById(id);
    }

    @Override
    public List<Goods> queryByName(String goodsName) {
        return goodsDao.selectByGoodsName(goodsName);
    }

    @Override
    public Boolean existGoodsId(Integer goodsId) {
        Integer selectByGoodsId = goodsDao.selectByGoodsId(goodsId);
        return selectByGoodsId == null;
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDao.insertGoods(goods);
    }

    @Override
    public void modifyGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public void removeGoods(Integer id) {
        goodsDao.deleteById(id);
    }

    @Override
    public void outGoods(Integer id, Integer outNum,Integer userId) {
        // 通过id查出对应商品
        Goods goods = goodsDao.selectById(id);
        //判断商品数量是否足够出库
        if (outNum > goods.getGoodsNum()) {
            return;
        }
        //足够就出库
        goods.setGoodsNum(goods.getGoodsNum() - outNum);
        record = new Record();
        record.setUserId(userId);
        record.setGoodsName(goods.getGoodsName());
        record.setOperationNum(-outNum);
        record.setOperationType(-1);
        record.setOperationTime(new Date());
        recordDao.insertRecord(record);
        goodsDao.updateGoods(goods);
    }

    @Override
    public void inGoods(Integer id, Integer inNum,Integer userId) {
        // 通过id查出对应商品
        Goods goods = goodsDao.selectById(id);
        //入库
        goods.setGoodsNum(goods.getGoodsNum() + inNum);
        record = new Record();
        record.setUserId(userId);
        record.setGoodsName(goods.getGoodsName());
        record.setOperationNum(inNum);
        record.setOperationType(1);
        record.setOperationTime(new Date());
        recordDao.insertRecord(record);
        goodsDao.updateGoods(goods);
    }


}
