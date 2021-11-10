package com.huapi.redis.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/10.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student implements Serializable {
    
    private Long id;
    private String name;
    private Integer age;
    
}
