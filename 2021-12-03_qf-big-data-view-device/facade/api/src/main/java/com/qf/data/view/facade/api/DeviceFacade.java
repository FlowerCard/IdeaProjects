package com.qf.data.view.facade.api;

import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.device.AddDeviceModelRequest;
import com.qf.data.view.facade.response.device.AddDeviceModelResponse;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
public interface DeviceFacade {
    
    ResultModel<AddDeviceModelResponse> addDevice(AddDeviceModelRequest request);
    
}
