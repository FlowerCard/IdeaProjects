package com.qf.bigdata.view.web.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.bigdata.view.web.service.DeviceService;
import com.qf.data.view.core.model.request.AddDeviceRequest;
import com.qf.data.view.core.model.response.AddDeviceResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.api.DeviceFacade;
import com.qf.data.view.facade.request.device.AddDeviceModelRequest;
import com.qf.data.view.facade.response.device.AddDeviceModelResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    
    @Reference
    private DeviceFacade deviceFacade;
    
    @Override
    public ResultModel<AddDeviceResponse> addDevice(AddDeviceRequest request) {
        
        AddDeviceResponse addDeviceResponse = new AddDeviceResponse();
        try {
            AddDeviceModelRequest modelRequest = new AddDeviceModelRequest();
            BeanUtils.copyProperties(request,modelRequest);
            // 调用下游 facade
            ResultModel<AddDeviceModelResponse> responseResultModel = deviceFacade.addDevice(modelRequest);
            BeanUtils.copyProperties(responseResultModel.getData(),addDeviceResponse);

        } catch (BeansException e) {
            e.printStackTrace();
            return ResultModel.error(e.getMessage());
        }
        return ResultModel.success(addDeviceResponse);
    }
}
