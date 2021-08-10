package com.qf.test08101.zuoye;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class SellTicket extends Thread{

    /**
     * 初始100张票
     */
    private Integer ticket = 100;

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        //获取名字
        String name = Thread.currentThread().getName();

        while (true) {
            //同步代码块
            synchronized (this) {
                if (this.ticket > 0) {
                    System.out.println(name + "正在出票：" + this.ticket);
                    this.ticket--;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
