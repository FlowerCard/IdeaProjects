package com.qf.test07302.test07;

/**
 * XXX纯净水生产线-纯净水02
 * @author HuaPai@odcn.live
 */
public class Water02 extends Water implements IBuffer{
    /**
     * 缓冲
     */
    @Override
    public void buffer() {
        System.out.println("纯净水02缓冲");
    }

    /**
     * 取水
     */
    @Override
    public void getWater() {
        System.out.println("纯净水02取水");
    }
}
