package com.qf.data.view.core.service.impl;

import com.qf.data.core.dal.dao.DeviceMapper;
import com.qf.data.core.dal.po.DevicePO;
import com.qf.data.view.core.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    
    @Autowired
    private DeviceMapper deviceMapper;
    
    @Override
    public int insert(DevicePO record) {
        return 0;
    }

    @Override
    public int insertSelective(DevicePO record) {
        return deviceMapper.insertSelective(record);
    }

    @Override
    public DevicePO selectById(Long id) {
        return deviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public DevicePO selectByDeviceKey(String deviceKey) {
        return deviceMapper.selectByDeviceKey(deviceKey);
    }
}
