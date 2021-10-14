package com.huapai.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 记录实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Component
public class Record {

    /**
     * 出入库记录ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 操作类型
     *  -1：出库
     *  1：入库
     */
    private Integer operationType;
    /**
     * 操作数量
     */
    private Integer operationNum;
    /**
     * 操作时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date operationTime;

}
