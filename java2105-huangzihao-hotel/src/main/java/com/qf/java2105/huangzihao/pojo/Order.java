package com.qf.java2105.huangzihao.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Order {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 桌子ID
     */
    private Long tableId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 菜总数量
     */
    private Long dishsNumber;
    /**
     * 下单总金额
     */
    private BigDecimal totalAmount;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 关联餐桌
     * 多个菜单对应一个餐桌
     */
    private Table table;

    /**
     * 关联订单详情
     * 多个订单对多个订单详情
     */
    private List<OrderDetails> orderDetails;

    /**
     * 关联用户实体
     * 多个订单对应单个用户
     */
    private User user;

    public Order() {
    }

    public Order(Long orderId, Long tableId, Long userId, Long dishsNumber, BigDecimal totalAmount, Date orderTime, Integer orderStatus) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.userId = userId;
        this.dishsNumber = dishsNumber;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDishsNumber() {
        return dishsNumber;
    }

    public void setDishsNumber(Long dishsNumber) {
        this.dishsNumber = dishsNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
