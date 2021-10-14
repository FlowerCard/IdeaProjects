package com.huapai.entity;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Goods {

    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 商品编号
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 商品类别
     */
    private Integer goodsType;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商品信息
     */
    private String goodsInfo;
    
}
