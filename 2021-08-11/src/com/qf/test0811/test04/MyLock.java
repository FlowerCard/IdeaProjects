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

    /**
     * 写
     * @param value 需要写入的值
     */
    public void setValue(Integer value) {
        locker.lock();
        try {
            this.value = value;
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    /**
     * 读
     * @return 返回被读取的值
     */
    public Integer getValue() {
        locker.lock();
        try {
            Thread.sleep(1000);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
        return null;
    }
}
