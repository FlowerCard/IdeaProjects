package com.qf.data.view.core.service.device;

import com.qf.data.core.dal.po.DevicePO;
import com.qf.data.view.core.service.base.BaseService;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 * 设备接口
 */
public interface DeviceService extends BaseService<DevicePO> {
    
    DevicePO selectByDeviceKey(String deviceKey);
    
}
