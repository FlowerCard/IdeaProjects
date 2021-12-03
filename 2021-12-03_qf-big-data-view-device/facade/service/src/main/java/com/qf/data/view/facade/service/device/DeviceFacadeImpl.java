package com.qf.data.view.facade.service.device;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.data.core.dal.po.DevicePO;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.core.service.device.DeviceService;
import com.qf.data.view.facade.api.DeviceFacade;
import com.qf.data.view.facade.request.device.AddDeviceModelRequest;
import com.qf.data.view.facade.response.device.AddDeviceModelResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@Service
public class DeviceFacadeImpl implements DeviceFacade {
    
    @Autowired
    private DeviceService deviceService;
    
    @Override
    public ResultModel<AddDeviceModelResponse> addDevice(AddDeviceModelRequest request) {

        if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
            return ResultModel.error("Please do not pass in a null value !");
        }

        DevicePO devicePO = new DevicePO();
        devicePO.setDeviceKey(request.getDeviceKey());
        // 手动封装最后活跃时间
        devicePO.setLastActiveTime(System.currentTimeMillis());
        deviceService.insertSelective(devicePO);
        AddDeviceModelResponse addDeviceModelResponse = new AddDeviceModelResponse();
        addDeviceModelResponse.setDeviceKey(request.getDeviceKey());
        return ResultModel.success(addDeviceModelResponse);
    }
}
