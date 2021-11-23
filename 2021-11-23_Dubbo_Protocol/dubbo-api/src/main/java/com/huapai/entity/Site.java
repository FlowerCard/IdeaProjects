package com.huapai.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Site implements Serializable {
    
    private static final long serialVersionUID = 42L;

    /**
     * 工地ID
     */
    private Long id;
    /**
     * 工地名称
     */
    private String siteName;
    
}
