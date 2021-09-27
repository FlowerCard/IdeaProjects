package com.huapai.service.impl;

import com.huapai.service.ITransferService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 转账业务层实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Service("transferService")
public class TransferServiceImpl implements ITransferService {

    private Double defaultMoney = 10000.0;

    public Double getDefaultMoney() {
        return defaultMoney;
    }

    /**
     * 转出
     *
     * @param amount 金额
     * @return
     */
    @Override
    public Double rollOut(Double amount) {
        if (getDefaultMoney() < amount) {
            System.out.println("转账失败");
            return getDefaultMoney();
        } else {
            return defaultMoney - amount;
        }
    }

    /**
     * 转入
     *
     * @param amount 金额
     * @return
     */
    @Override
    public Double into(Double amount) {
        return defaultMoney + amount;
    }
}
