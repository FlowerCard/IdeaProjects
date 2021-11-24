package com.qf.data.view.facade.request.device;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Data
public class GetDeviceModelRequest implements Serializable {

    private String deviceKey;
    
}
