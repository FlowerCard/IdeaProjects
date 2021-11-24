package com.qf.data.core.dal.dao;

import com.qf.data.core.dal.po.DevicePO;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 * 设备接口
 */
public interface DeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevicePO record);

    int insertSelective(DevicePO record);

    DevicePO selectByPrimaryKey(Integer id);
    
    DevicePO selectByDeviceKey(String deviceKey);

    int updateByPrimaryKeySelective(DevicePO record);

    int updateByPrimaryKey(DevicePO record);
    
}