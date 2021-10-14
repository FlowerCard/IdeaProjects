package com.huapai.service.impl;

import com.huapai.dao.IRecordDao;
import com.huapai.entity.Record;
import com.huapai.service.IRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 记录业务层实现
 */
@Service("recordService")
@Transactional
public class RecordServiceImpl implements IRecordService {
    
    @Resource
    private IRecordDao recordDao;
    
    @Override
    public List<Record> queryAll() {
        return recordDao.selectAll();
    }

    @Override
    public void removeRecord(Integer id) {
        recordDao.deleteById(id);
    }
}
