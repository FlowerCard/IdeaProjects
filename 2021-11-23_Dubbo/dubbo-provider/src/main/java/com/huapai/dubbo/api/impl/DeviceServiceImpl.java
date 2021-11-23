package com.huapai.dubbo.api.impl;

import com.huapai.dubbo.api.DeviceService;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
public class DeviceServiceImpl implements DeviceService {
    /**
     * 获取设备名称
     *
     * @param id 设备id
     * @return 设备名称
     */
    @Override
    public String getDeviceName(Long id) {
        return "设备id：" + id;
    }
}
