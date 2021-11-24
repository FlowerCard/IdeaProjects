package com.qf.data.view.facade.request.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Data
public class AddDeviceModelRequest implements Serializable {

    /**
     * 设备ID
     */
    private String deviceKey;

    /**
     * 最后活跃时间
     */
    private Date lastActiveTime;
    
}
