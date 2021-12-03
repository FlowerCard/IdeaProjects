package com.qf.data.view.core.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@Data
public class AddDeviceResponse implements Serializable {

    private String deviceKey;

    private static final long serialVersionUID = 1L;
}
