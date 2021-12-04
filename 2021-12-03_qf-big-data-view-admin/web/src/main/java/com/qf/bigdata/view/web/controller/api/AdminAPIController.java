package com.qf.bigdata.view.web.controller.api;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.huapai.extservice.api.MyExtAPI;
import com.huapai.extservice.api.request.AddDeviceModelRequest;
import com.huapai.extservice.api.response.AddDeviceModelResponse;
import com.qf.data.view.core.model.exception.ViewException;
import com.qf.data.view.core.model.request.AdminDeviceRequest;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/4.
 */
@RestController
@RequestMapping("/admin")
public class AdminAPIController {
    
    @Reference
    private MyExtAPI deviceService;
    
    @PostMapping("/device/add")
    public ResultModel addDevice(@RequestBody AdminDeviceRequest request) {
        try {
            if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
                throw new ViewException("params error ...");
            }
        } catch (ViewException e) {
            return ResultModel.error(e.getMessage());
        }

        AddDeviceModelRequest modelRequest = new AddDeviceModelRequest();
        BeanUtils.copyProperties(request,modelRequest);

        AddDeviceModelResponse deviceModelResponse = deviceService.addDevice(modelRequest);
        return ResultModel.success(deviceModelResponse);
    }
    
}
