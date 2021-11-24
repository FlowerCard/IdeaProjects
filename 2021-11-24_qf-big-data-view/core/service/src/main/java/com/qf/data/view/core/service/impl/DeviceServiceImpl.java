package com.qf.data.view.core.service.impl;

import com.qf.data.core.dal.dao.DeviceMapper;
import com.qf.data.core.dal.po.DevicePO;
import com.qf.data.view.core.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    
    @Autowired
    private DeviceMapper deviceMapper;
    
    @Override
    public int insert(DevicePO record) {
        return deviceMapper.insertSelective(record);
    }

    @Override
    public DevicePO selectById(Long id) {
        return deviceMapper.selectByPrimaryKey(id.intValue());
    }

    @Override
    public DevicePO selectByDeviceKey(String deviceKey) {
        return deviceMapper.selectByDeviceKey(deviceKey);
    }
}
