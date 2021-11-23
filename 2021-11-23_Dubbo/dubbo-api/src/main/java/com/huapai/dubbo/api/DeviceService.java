package com.huapai.dubbo.api;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
public interface DeviceService {

    /**
     * 获取设备名称
     * @param id 设备id
     * @return 设备名称
     */
    String getDeviceName(Long id);
    
}
