package com.qf.test07302.test07;

/**
 * XXX纯净水生产线-纯净水03
 * @author HuaPai@odcn.live
 */
public class Water03 extends Water implements IFilter{
    /**
     * 过滤
     */
    @Override
    public void filter() {
        System.out.println("纯净水03过滤");
    }

    /**
     * 取水
     */
    @Override
    public void getWater() {
        System.out.println("纯净水03取水");
    }
}
