package com.qf.bigdata.view.web.service;

import com.qf.data.view.core.model.request.AddDeviceRequest;
import com.qf.data.view.core.model.request.GetDeviceRequest;
import com.qf.data.view.core.model.request.ModifyDeviceRequest;
import com.qf.data.view.core.model.response.GetDeviceResponse;
import com.qf.data.view.core.model.result.ResultModel;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
public interface DeviceService {
    
    GetDeviceResponse info(GetDeviceRequest request);
    
    ResultModel<String> insert(AddDeviceRequest request);
    
    ResultModel modify(ModifyDeviceRequest request);
    
}
