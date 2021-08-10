package com.qf.test08101.test04;

import org.junit.Test;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class TickRunnableTest {

    public static void main(String[] args) {
        TickRunnable tickRunnable = new TickRunnable();

        Thread t1 = new Thread(tickRunnable,"窗口1：");
        Thread t2 = new Thread(tickRunnable,"窗口2：");
        Thread t3 = new Thread(tickRunnable,"窗口3：");

        t1.start();
        t2.start();
        t3.start();
    }

}
