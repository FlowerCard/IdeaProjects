package com.huapai.extservice.api;

import com.huapai.extservice.api.request.AddDeviceModelRequest;
import com.huapai.extservice.api.response.AddDeviceModelResponse;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/4.
 */
public interface MyExtAPI {
    
    AddDeviceModelResponse addDevice(AddDeviceModelRequest request);
    
}
