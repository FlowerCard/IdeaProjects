package com.java2105.huangzihao.test04;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class Maker extends Thread {

    Bread bread;

    public Maker(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        synchronized (bread) {
            while (true) {
                //如果有面包就等待
                if (bread.isFlag()) {
                    try {
                        bread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //没有就生成面包
                bread.setFlag(true);
                System.out.println(name + " -----> 正在 <生产> 面包" + System.currentTimeMillis());
                try {
                    //模拟生产面包的时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //告诉食客可以吃了
                bread.notify();

            }
        }

    }
}
