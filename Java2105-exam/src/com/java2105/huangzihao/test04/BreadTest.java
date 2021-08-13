package com.java2105.huangzihao.test04;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class BreadTest {

    public static void main(String[] args) {

        //实例化对象
        Bread bread = new Bread();
        Maker maker = new Maker(bread);
        Eater eater = new Eater(bread);

        //设置线程名名称
        maker.setName("面包店");
        eater.setName("食客");

        //启动线程
        maker.start();
        eater.start();

    }

}
