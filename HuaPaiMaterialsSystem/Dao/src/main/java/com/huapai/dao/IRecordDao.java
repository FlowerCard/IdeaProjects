package com.huapai.dao;

import com.huapai.entity.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 记录持久层接口
 */
@Repository("recordDao")
public interface IRecordDao {

    /**
     * 查询所有记录
     * @return 记录集合
     */
    public List<Record> selectAll();

    /**
     * 插入记录
     * @param record 插入记录
     * @return 受影响行数
     */
    public Integer insertRecord(Record record);

    /**
     * 通过id删除
     * @param id 记录id
     * @return 受影响行数
     */
    public Integer deleteById(Integer id);
    
}
