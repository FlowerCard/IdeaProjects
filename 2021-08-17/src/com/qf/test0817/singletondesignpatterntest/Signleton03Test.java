package com.qf.test0817.singletondesignpatterntest;

/**
 * 饿汉式
 *  线程安全
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/17.
 */
public class Signleton03Test {

    //构造器私有
    private Signleton03Test() {}

    // 创建一个私有的静态实例引用，直接赋值
    private static Signleton03Test signleton = new Signleton03Test();

    // 创建一个公有的静态的返回实例对象的方法
    public static Signleton03Test getInstance() {
        return signleton;
    }

}
