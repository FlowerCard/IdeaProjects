package com.qf.data.view.core.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Data
public class GetDeviceRequest implements Serializable {
    private String deviceKey;
}
