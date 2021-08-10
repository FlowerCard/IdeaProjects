package com.qf.test08101.test05;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class ProducersBaoZi extends Thread{
    /**
     * 共享资源
     */
    private BaoZi baoZi;

    public ProducersBaoZi(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    /**
     * 生产包子
     */
    @Override
    public void run() {
        //获取线程名称
        String name = Thread.currentThread().getName();
        synchronized (this.baoZi) {
            while (true) {
                if (baoZi.getSign()) {
                    //如果有包子，就停止生产
                    try {
                        //等待
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果没有包子，就停止生产
                baoZi.setPi("薄皮");
                baoZi.setXian("香辣粉丝");
                System.out.println(name + "正在生产 " + baoZi.getPi() + baoZi.getXian() + "包子-----------------------");
                baoZi.setSign(true);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi.notify();
            }
        }
    }
}
