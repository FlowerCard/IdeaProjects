package com.huapai.entity;

import lombok.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 商品类别实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GoodsType {

    /**
     * 商品类型ID
     */
    private Integer id;
    /**
     * 商品类型编号
     */
    private Integer typeId;
    /**
     * 商品类型名称
     */
    private String typeName;
    /**
     * 商品类型介绍
     */
    private String typeInfo;

}
