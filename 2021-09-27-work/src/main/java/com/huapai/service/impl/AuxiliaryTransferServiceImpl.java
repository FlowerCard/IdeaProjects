package com.huapai.service.impl;

import com.huapai.service.ITransferService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/27.
 */
@Service("auxiliaryTransferService")
public class AuxiliaryTransferServiceImpl implements ITransferService {
    
    /**
     * 转出
     *
     * @param amount 金额
     * @return
     */
    @Override
    public Double rollOut(Double amount) {
        TransferServiceImpl transferService = new TransferServiceImpl();
        System.out.println("转账中，请稍等。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amount > transferService.getDefaultMoney()) {
            System.out.println("转账失败，金额不足");
            return transferService.getDefaultMoney();
        }
        System.out.println("转账成功！！！");
        return transferService.rollOut(amount);
    }

    /**
     * 转入
     *
     * @param amount 金额
     * @return
     */
    @Override
    public Double into(Double amount) {
        TransferServiceImpl transferService = new TransferServiceImpl();
        System.out.println("转入中，请稍等。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("转入成功！！！");
        return transferService.into(amount);
    }
}
