package com.huapai.service;

import com.huapai.entity.Record;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 记录业务层接口
 */
public interface IRecordService {

    /**
     * 查询所有记录
     * @return 记录集合
     */
    public List<Record> queryAll();

    /**
     * 删除记录
     * @param id 记录id
     */
    public void removeRecord(Integer id);
    
}
