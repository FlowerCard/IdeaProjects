package com.huapai.singleton;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 * 懒汉式
 */
public class Singleton01 {
    
    private static Singleton01 instance;
    
    private Singleton01(){};
    
    public static synchronized Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
    
}
