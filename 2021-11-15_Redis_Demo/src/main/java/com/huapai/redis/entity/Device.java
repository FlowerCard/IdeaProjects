package com.huapai.redis.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Device implements Serializable {
    
    private Long id;
    private String deviceName;
    
}
