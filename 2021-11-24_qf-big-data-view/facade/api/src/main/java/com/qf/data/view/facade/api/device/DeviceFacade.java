package com.qf.data.view.facade.api.device;

import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.device.AddDeviceModelRequest;
import com.qf.data.view.facade.request.device.GetDeviceModelRequest;
import com.qf.data.view.facade.response.GetDeviceModelResponse;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
public interface DeviceFacade {
    
    ResultModel<GetDeviceModelResponse> getDeviceInfo(GetDeviceModelRequest request);
    
    ResultModel<String> addDeviceInfo(AddDeviceModelRequest request);
    
}
