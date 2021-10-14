package com.huapai.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    @JSONField(serialize = false)
    private String password;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户联系方式
     */
    private String telephone;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 用户身份
     *  0：商户
     *  1：管理严
     */
    private Integer isAdmin;
    /**
     * 用户状态
     *  0：正常
     *  1：删除
     */
    private Integer isDelete;

}
