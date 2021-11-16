package com.huapai.zookeeper.testcode;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/16.
 */
//@SpringBootTest
public class CuratorReadWriteLockTests {
    
    @Autowired
    private CuratorFramework curatorFramework;

    /**
     * 获取读锁
     */
//    @Test
    void testGetReadLock() throws Exception {
        // 读写锁
        InterProcessReadWriteLock interProcessReadWriteLock = new InterProcessReadWriteLock(curatorFramework,"/readLock");
        // 获取读锁对象
        InterProcessLock interProcessLock = interProcessReadWriteLock.readLock();
        System.out.println("等待获取读锁对象......");
        // 获取锁
        interProcessLock.acquire();
        for (int i = 1; i <= 30; i++) {
            Thread.sleep(2000);
            System.out.println(i);
        }
        
        // 释放锁
        interProcessLock.release();
        System.out.println("等待释放锁......");
    }

    /**
     * 获取写锁
     */
//    @Test
    void testGetWriteLock() throws Exception {
        // 读写锁
        InterProcessReadWriteLock interProcessReadWriteLock = new InterProcessReadWriteLock(curatorFramework,"/readLock");
        // 获取写锁对象
        InterProcessLock interProcessLock = interProcessReadWriteLock.writeLock();
        System.out.println("等待获取写锁对象......");
        // 获取锁
        interProcessLock.acquire();
        for (int i = 1; i <= 30; i++) {
            Thread.sleep(2000);
            System.out.println(i);
        }
        
        // 释放锁
        interProcessLock.release();
        System.out.println("等待释放锁......");
    }
    
}
