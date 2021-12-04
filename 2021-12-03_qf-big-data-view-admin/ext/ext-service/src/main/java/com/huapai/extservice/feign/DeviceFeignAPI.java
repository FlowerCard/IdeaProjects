package com.huapai.extservice.feign;

import com.huapai.extservice.api.request.feign.AddDeviceRequest;
import com.huapai.extservice.api.response.feign.AddDeviceResponse;
import com.huapai.extservice.feign.fallback.DeviceFallback;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/4.
 */
@FeignClient(name = "device-web", fallback = DeviceFallback.class, path = "/device")
//@FeignClient(name = "my-zuul", fallback = )
public interface DeviceFeignAPI {
    
    @PostMapping("/add")
    ResultModel<AddDeviceResponse> addDevice(@RequestBody AddDeviceRequest request);
    
}
