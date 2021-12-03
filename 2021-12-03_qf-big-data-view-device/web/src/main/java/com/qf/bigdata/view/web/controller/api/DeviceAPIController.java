package com.qf.bigdata.view.web.controller.api;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.qf.bigdata.view.web.service.DeviceService;
import com.qf.data.view.core.model.exception.ViewException;
import com.qf.data.view.core.model.request.AddDeviceRequest;
import com.qf.data.view.core.model.response.AddDeviceResponse;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@RestController
@RequestMapping("/device")
public class DeviceAPIController {
    
    @Autowired
    private DeviceService deviceService;
    
    @RequestMapping("/add")
    public ResultModel<AddDeviceResponse> addDevice(@RequestBody AddDeviceRequest request) {
        try {
            if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
                throw new ViewException("params error...");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }
        return deviceService.addDevice(request);
    }
    
}
