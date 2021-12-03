package com.qf.data.core.dal.po;

import java.io.Serializable;

import com.qf.data.view.core.model.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/3.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DevicePO extends BaseDTO implements Serializable {
    private Long id;

    private String deviceKey;

    private Long lastActiveTime;

    private static final long serialVersionUID = 1L;

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey == null ? null : deviceKey.trim();
    }
}