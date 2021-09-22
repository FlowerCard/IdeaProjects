package com.huapai.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/22.
 */
@Data
public class Table implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 桌号
     */
    private Integer tableId;
    /**
     * 桌名
     */
    private String tableName;
    /**
     * 餐桌状态
     */
    private Integer tableStatus;
    /**
     * 预定时间
     */
    private Date scheduledTime;
}
