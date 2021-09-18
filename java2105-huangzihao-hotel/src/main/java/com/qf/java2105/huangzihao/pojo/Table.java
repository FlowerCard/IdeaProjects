package com.qf.java2105.huangzihao.pojo;

import java.util.Date;

/**
 * 餐桌实体类
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Table {

    /**
     * 餐桌ID
     */
    private Long tableId;
    /**
     * 餐桌名称
     */
    private String tableName;
    /**
     * 餐桌状态
     */
    private Integer tableStatus;
    /**
     * 餐桌预定时间
     */
    private Date scheduledTime;

    public Table() {
    }

    public Table(Long tableId, String tableName, Integer tableStatus, Date scheduledTime) {
        this.tableId = tableId;
        this.tableName = tableName;
        this.tableStatus = tableStatus;
        this.scheduledTime = scheduledTime;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
