package com.java2105.huangzihao.test04;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class Eater extends Thread {

    Bread bread;

    public Eater(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {

        //获取线程名称
        String name = Thread.currentThread().getName();

        synchronized (bread) {
            while (true) {
                //有面包就吃面包
                if (bread.isFlag()) {
                    bread.setFlag(false);
                    System.out.println(name + " -----> 正在 <吃> 面包" + System.currentTimeMillis());
                    try {
                        //模拟吃面包的时间
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //吃完面包告诉面包店
                    bread.notify();
                }

                try {
                    //没有就等待
                    bread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}
