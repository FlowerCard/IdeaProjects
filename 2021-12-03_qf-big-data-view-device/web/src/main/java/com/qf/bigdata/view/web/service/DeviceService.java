package com.qf.bigdata.view.web.service;

import com.qf.data.view.core.model.request.AddDeviceRequest;
import com.qf.data.view.core.model.response.AddDeviceResponse;
import com.qf.data.view.core.model.result.ResultModel;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
public interface DeviceService {
    
    ResultModel<AddDeviceResponse> addDevice(AddDeviceRequest request);
    
}
