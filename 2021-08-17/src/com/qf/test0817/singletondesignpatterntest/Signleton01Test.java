package com.qf.test0817.singletondesignpatterntest;

/**
 * 懒汉式
 *      存在线程不安全
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/17.
 */
public class Signleton01Test {

    // 1.构造器私有
    private Signleton01Test(){}

    // 2.创建私有的静态实例引用，不用赋值
    private static Signleton01Test signleton = null;

    // 3.创建一个公有的静态方法返回对象实例
    public static Signleton01Test getInstance() {
        // 判断是否创建实例
        if (signleton == null) {
            signleton = new Signleton01Test();
        }
        return signleton;
    }

}
