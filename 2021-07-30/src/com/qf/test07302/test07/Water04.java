package com.qf.test07302.test07;

/**
 * XXX纯净水生产线-纯净水04
 * @author HuaPai@odcn.live
 */
public class Water04 extends Water implements ISugar{
    /**
     * 放糖
     */
    @Override
    public void sugar() {
        System.out.println("纯净水04放糖(PS:剧毒)");
    }

    /**
     * 取水
     */
    @Override
    public void getWater() {
        System.out.println("纯净水04取水");
    }
}
