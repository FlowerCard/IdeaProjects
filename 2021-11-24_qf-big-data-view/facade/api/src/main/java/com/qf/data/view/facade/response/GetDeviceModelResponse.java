package com.qf.data.view.facade.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/24.
 */
@Data
public class GetDeviceModelResponse implements Serializable {

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
    
}
