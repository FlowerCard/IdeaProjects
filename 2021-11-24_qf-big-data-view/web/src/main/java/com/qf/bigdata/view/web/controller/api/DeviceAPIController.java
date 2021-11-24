package com.qf.bigdata.view.web.controller.api;

import com.qf.bigdata.view.web.service.DeviceService;
import com.qf.data.view.core.model.exception.DeviceException;
import com.qf.data.view.core.model.request.AddDeviceRequest;
import com.qf.data.view.core.model.request.GetDeviceRequest;
import com.qf.data.view.core.model.response.GetDeviceResponse;
import com.qf.data.view.core.model.result.ResultModel;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@RestController
@RequestMapping("/device")
public class DeviceAPIController {
    
    @Autowired
    private DeviceService deviceService;
    
    @PostMapping("/info")
    public ResultModel<GetDeviceResponse> getDeviceById(@RequestBody GetDeviceRequest request) {
        
        if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
            try {
                throw new DeviceException("参数异常");
            } catch (DeviceException e) {
                e.printStackTrace();
                return ResultModel.error(e.getMessage());
            }
        }

        GetDeviceResponse info = deviceService.info(request);
        if (Objects.nonNull(info)) {
            return ResultModel.success(info);
        } else {
            return ResultModel.error("无数据");
        }
        
    }
    
    @PostMapping("/add")
    public ResultModel<String> addDevice(@RequestBody AddDeviceRequest request) {
        return deviceService.insert(request);
    }
    
}
