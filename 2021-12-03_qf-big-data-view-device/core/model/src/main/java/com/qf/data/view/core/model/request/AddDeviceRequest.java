package com.qf.data.view.core.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@Data
public class AddDeviceRequest implements Serializable {
    
    private Long id;

    private String deviceKey;

    private Long lastActiveTime;

    private static final long serialVersionUID = 1L;
    
}
