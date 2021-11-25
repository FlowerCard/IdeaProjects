package com.qf.data.core.dal.po;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.qf.data.view.core.model.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 * 设备实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DevicePO extends BaseDTO implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 设备ID
     */
    private String deviceKey;

    /**
     * 最后活跃时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastActiveTime;

    private static final long serialVersionUID = 1L;
}