package com.huapai.singleton;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 * 双重校验锁
 */
public class Singleton03 {
    
    private static Singleton03 instance;
    
    private Singleton03() {};
    
    private static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
    
}
