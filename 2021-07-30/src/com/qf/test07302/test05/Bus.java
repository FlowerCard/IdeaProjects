package com.qf.test07302.test05;

/**
 * 巴士
 * @author HuaPai@odcn.live
 */
public class Bus implements Vehicle{
    @Override
    public void start(String content) {
        System.out.println(content + "巴士启动");
    }

    @Override
    public void stop(String content) {
        System.out.println(content + "巴士停止");
    }
}
