package com.huapai.jdkproxy;

/**
 * 房东
 *  出租房屋
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 */
public class Landlord implements Rent {
    @Override
    public Double rent(Double amount) {
        System.out.println("房东出租房屋");
        return amount;
    }
}
