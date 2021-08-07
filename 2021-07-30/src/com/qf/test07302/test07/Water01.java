package com.qf.test07302.test07;

/**
 * XXX纯净水生产线-纯净水01
 * @author HuaPai@odcn.live
 */
public class Water01 extends Water implements IFilter,IBuffer{
    /**
     * 缓冲
     */
    @Override
    public void buffer() {
        System.out.println("纯净水01缓冲");
    }

    /**
     * 过滤
     */
    @Override
    public void filter() {
        System.out.println("纯净水01过滤");
    }

    /**
     * 取水
     */
    @Override
    public void getWater() {
        System.out.println("纯净水01取水");
    }
}
