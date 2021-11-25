package com.qf.data.view.facade.service.device;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.data.core.dal.po.DevicePO;
import com.qf.data.view.core.model.exception.DeviceException;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.core.service.device.DeviceService;
import com.qf.data.view.facade.api.device.DeviceFacade;
import com.qf.data.view.facade.request.device.AddDeviceModelRequest;
import com.qf.data.view.facade.request.device.GetDeviceModelRequest;
import com.qf.data.view.facade.request.device.ModifyDeviceModelRequest;
import com.qf.data.view.facade.response.GetDeviceModelResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Service
public class DeviceFacadeImpl implements DeviceFacade {
    
    @Autowired
    private DeviceService deviceService;
    
    @Override
    public ResultModel<GetDeviceModelResponse> getDeviceInfo(GetDeviceModelRequest request) {
        
        // 判断参数是否为空
        if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
            try {
                throw new DeviceException("参数异常");
            } catch (DeviceException e) {
                e.printStackTrace();
            }
        }

        // 通过设备ID查询设备
        DevicePO devicePO = deviceService.selectByDeviceKey(request.getDeviceKey());
        
        GetDeviceModelResponse response = new GetDeviceModelResponse();

        // 判断对象是否为空
        if (Objects.nonNull(devicePO)) {
            BeanUtils.copyProperties(devicePO, response);
            return ResultModel.success(response);
        }
        return ResultModel.error("无数据");
    }

    @Override
    public ResultModel<String> addDeviceInfo(AddDeviceModelRequest request) {

        // 判断参数是否为空
        if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
            try {
                throw new DeviceException("参数异常");
            } catch (DeviceException e) {
                e.printStackTrace();
            }
        }
        
        DevicePO devicePO = new DevicePO();
        devicePO.setDeviceKey(request.getDeviceKey());
        devicePO.setLastActiveTime(new Date());

        int row = deviceService.insertSelective(devicePO);
        
        if (row > 0){
            return ResultModel.success("插入成功");
        }

        return ResultModel.error("插入失败");
    }

    @Override
    public ResultModel<GetDeviceModelResponse> modifyDeviceInfo(ModifyDeviceModelRequest request) {
        if (Objects.isNull(request) || StringUtils.isBlank(request.getDeviceKey())) {
            try {
                throw new DeviceException("参数异常");
            } catch (DeviceException e) {
                e.printStackTrace();
            }
        }
        
        DevicePO devicePO = new DevicePO();
        devicePO.setDeviceKey(request.getDeviceKey());
        devicePO.setLastActiveTime(new Date());

        int row = deviceService.updateByDeviceKey(devicePO);

        GetDeviceModelResponse getDeviceModelResponse = new GetDeviceModelResponse();
        if (row > 0) {
            DevicePO select = deviceService.selectByDeviceKey(request.getDeviceKey());
            getDeviceModelResponse.setDeviceKey(select.getDeviceKey());
            getDeviceModelResponse.setLastActiveTime(select.getLastActiveTime());
            return ResultModel.success("修改后的数据为",getDeviceModelResponse);
        } else {
            return ResultModel.error("修改失败");
        }
    }
}
