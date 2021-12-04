package com.huapai.extservice.impl;

import com.huapai.extservice.api.MyExtAPI;
import com.huapai.extservice.api.request.AddDeviceModelRequest;
import com.huapai.extservice.api.request.feign.AddDeviceRequest;
import com.huapai.extservice.api.response.AddDeviceModelResponse;
import com.huapai.extservice.api.response.feign.AddDeviceResponse;
import com.huapai.extservice.feign.DeviceFeignAPI;
import com.qf.data.view.core.model.result.ResultModel;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/4.
 */
@Service
public class ExtAPIImpl implements MyExtAPI {
    
    @Autowired
    private DeviceFeignAPI deviceFeignAPI;
    
    @Override
    public AddDeviceModelResponse addDevice(AddDeviceModelRequest request) {

        if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
            return null;
        }

        AddDeviceModelResponse modelResponse = new AddDeviceModelResponse();
        
        try {
            AddDeviceRequest addDeviceRequest = new AddDeviceRequest();

            BeanUtils.copyProperties(request,addDeviceRequest);
            ResultModel<AddDeviceResponse> addDeviceResponseResultModel = deviceFeignAPI.addDevice(addDeviceRequest);
            BeanUtils.copyProperties(addDeviceResponseResultModel.getData(),modelResponse);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return modelResponse;
    }
}
