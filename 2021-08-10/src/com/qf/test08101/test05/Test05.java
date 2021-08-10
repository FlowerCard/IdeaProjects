package com.qf.test08101.test05;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class Test05 {

    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();

        ProducersBaoZi producersBaoZi = new ProducersBaoZi(baoZi);
        ConsumerChiHuo consumerChiHuo = new ConsumerChiHuo(baoZi);

        producersBaoZi.setName("包子铺：");
        consumerChiHuo.setName("吃货：");

        producersBaoZi.start();
        consumerChiHuo.start();
    }

}
