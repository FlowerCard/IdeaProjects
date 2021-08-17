package com.qf.test0817.singletondesignpatterntest;

/**
 * 懒汉式
 *      解决存在线程不安全
 *      同步双重校验锁
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/17.
 */
public class Signleton02Test {

    // 1.构造器私有
    private Signleton02Test(){}

    // 2.创建私有的静态实例引用，不用赋值
    // volatile 禁止指令重排
    private static volatile Signleton02Test signleton = null;

    // 3.创建一个公有的静态方法返回对象实例
    public static Signleton02Test getInstance() {
        // 判断是否创建实例
        if (signleton == null) {
            // 同步锁
            synchronized (Signleton01Test.class) {
                //双重校验
                if (signleton == null) {
                    signleton = new Signleton02Test();
                }
            }
        }
        return signleton;
    }

}
