package com.huapai.extservice.api.request.feign;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/4.
 */
@Data
public class AddDeviceRequest implements Serializable {
    private Long id;

    private String deviceKey;

    private Long lastActiveTime;

    private static final long serialVersionUID = 1L;
}
