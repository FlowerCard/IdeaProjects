package com.huapai.service;

/**
 * 转账业务层接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
public interface ITransferService {

    /**
     * 转出
     * @param amount 金额
     * @return
     */
    Double rollOut(Double amount);

    /**
     * 转入
     * @param amount 金额
     * @return
     */
    Double into(Double amount);
}
