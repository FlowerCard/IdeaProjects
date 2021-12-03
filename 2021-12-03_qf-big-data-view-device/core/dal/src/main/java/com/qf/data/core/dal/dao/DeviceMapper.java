package com.qf.data.core.dal.dao;

import com.qf.data.core.dal.po.DevicePO;
import org.springframework.stereotype.Repository;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@Repository(value = "deviceMapper")
public interface DeviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevicePO record);

    int insertSelective(DevicePO record);

    DevicePO selectByPrimaryKey(Long id);
    
    DevicePO selectByDeviceKey(String deviceKey);

    int updateByPrimaryKeySelective(DevicePO record);

    int updateByPrimaryKey(DevicePO record);
}