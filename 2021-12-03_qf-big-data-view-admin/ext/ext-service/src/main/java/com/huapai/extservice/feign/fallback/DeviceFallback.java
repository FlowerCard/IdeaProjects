package com.huapai.extservice.feign.fallback;

import com.huapai.extservice.api.request.feign.AddDeviceRequest;
import com.huapai.extservice.api.response.feign.AddDeviceResponse;
import com.huapai.extservice.feign.DeviceFeignAPI;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.stereotype.Component;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/4.
 */
@Component
public class DeviceFallback implements DeviceFeignAPI {
    @Override
    public ResultModel<AddDeviceResponse> addDevice(AddDeviceRequest request) {
        return ResultModel.error("add device fail !");
    }
}
