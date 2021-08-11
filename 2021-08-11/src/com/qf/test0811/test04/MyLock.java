package com.qf.test0811.test04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyLock {

    private Lock locker = new ReentrantLock();

    private Integer value;

    public void setValue(Integer value) {
        locker.lock();
        try {
            this.value = value;
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public Integer getValue() {
        locker.lock();
        try {
            Thread.sleep(100);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        return null;
    }
}
