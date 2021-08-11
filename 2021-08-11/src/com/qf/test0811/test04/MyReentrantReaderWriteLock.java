package com.qf.test0811.test04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyReentrantReaderWriteLock {

    private Integer value;

    private ReentrantReadWriteLock locker = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock rl = locker.readLock();

    private ReentrantReadWriteLock.WriteLock wl = locker.writeLock();

    /**
     * 读
     * @return
     */
    public Integer getValue() {
        rl.lock();
        try {
            return value;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            rl.unlock();
        }
        return null;
    }

    /**
     * 写
     * @param value
     */
    public void setValue(Integer value) {
        wl.lock();
        try {
            this.value = value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wl.unlock();
        }
    }
}
