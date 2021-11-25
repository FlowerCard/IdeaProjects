package com.qf.bigdata.view.web.service.impl;

import com.qf.bigdata.view.web.service.DeviceService;
import com.qf.data.view.core.model.request.AddDeviceRequest;
import com.qf.data.view.core.model.request.GetDeviceRequest;
import com.qf.data.view.core.model.request.ModifyDeviceRequest;
import com.qf.data.view.core.model.response.GetDeviceResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.api.device.DeviceFacade;
import com.qf.data.view.facade.request.device.AddDeviceModelRequest;
import com.qf.data.view.facade.request.device.GetDeviceModelRequest;
import com.qf.data.view.facade.request.device.ModifyDeviceModelRequest;
import com.qf.data.view.facade.response.GetDeviceModelResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    
    @Reference
    private DeviceFacade deviceFacade;

    /**
     * 1.封装参数
     * 2.调用服务提供者的接口
     * 3.解析结果
     * @param request
     * @return
     */
    @Override
    public GetDeviceResponse info(GetDeviceRequest request) {
        GetDeviceModelRequest deviceModelRequest = new GetDeviceModelRequest();
        deviceModelRequest.setDeviceKey(request.getDeviceKey());
        ResultModel<GetDeviceModelResponse> deviceInfo = deviceFacade.getDeviceInfo(deviceModelRequest);

        GetDeviceResponse deviceResponse = new GetDeviceResponse();
        GetDeviceModelResponse deviceModelResponse = deviceInfo.getData();

        if (Objects.nonNull(deviceModelResponse)) {
            BeanUtils.copyProperties(deviceModelResponse,deviceResponse);
        }

        return deviceResponse;
    }

    @Override
    public ResultModel<String> insert(AddDeviceRequest request) {
        AddDeviceModelRequest addDeviceModelRequest = new AddDeviceModelRequest();
        addDeviceModelRequest.setDeviceKey(request.getDeviceKey());
        return deviceFacade.addDeviceInfo(addDeviceModelRequest);
    }

    @Override
    public ResultModel modify(ModifyDeviceRequest request) {
        ModifyDeviceModelRequest modifyDeviceModelRequest = new ModifyDeviceModelRequest();
        modifyDeviceModelRequest.setDeviceKey(request.getDeviceKey());
        return deviceFacade.modifyDeviceInfo(modifyDeviceModelRequest);
    }
}
