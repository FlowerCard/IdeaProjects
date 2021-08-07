package com.qf.test07302.test05;

/**
 * 单车
 * @author HuaPai@odcn.live
 */
public class Bike implements Vehicle{

    @Override
    public void start(String content) {
        System.out.println(content + "牌单车启动");
    }

    @Override
    public void stop(String content) {
        System.out.println(content + "牌单车停止");
    }
}
