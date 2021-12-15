package com.huapai.singleton;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 * 饿汉式
 */
public class Singleton02 {
    
    private static Singleton02 instance = new Singleton02();
    
    private Singleton02() {};
    
    private Singleton02 getInstance() {
        return instance;
    }
    
}
