package com.qf.test08101.zuoye;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class SellTicketTest {

    public static void main(String[] args) {

        SellTicket sellTicket = new SellTicket();

        Thread t1 = new Thread(sellTicket,"窗口1");
        Thread t2 = new Thread(sellTicket,"窗口2");
        Thread t3 = new Thread(sellTicket,"窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
