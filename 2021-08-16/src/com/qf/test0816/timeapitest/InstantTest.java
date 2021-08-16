package com.qf.test0816.timeapitest;

import java.time.Instant;

/**
 * 时间戳
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class InstantTest {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);
        //获取时间戳秒值
        System.out.println(instant.getEpochSecond());

    }

}
