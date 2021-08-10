package com.qf.test08101.test05;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class ConsumerChiHuo extends Thread{

    /**
     * 共享资源
     */
    BaoZi baoZi;

    public ConsumerChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        //获取线程名称
        String name = Thread.currentThread().getName();

        synchronized (baoZi) {
            while (true) {
                if (baoZi.getSign()) {
                    //如果有包子就吃包子，告诉包子铺做包子
                    System.out.println(name + "正在吃" + baoZi.getPi() + baoZi.getXian() + "包子----------------------");
                    baoZi.setSign(false);
                    baoZi.notify();
                }
                //如果没有包子，就等待
                try {
                    baoZi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
