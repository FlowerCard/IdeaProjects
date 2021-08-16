package com.qf.test0816.timeapitest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 时间格式
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class DataChangeTest {

    public static void main(String[] args) {

        // Date ----> Instant ----> LocalDateTime
        Date date = new Date();

        //获取毫秒时间戳
        long time = date.getTime();
        System.out.println(time);

        System.out.println("----------------------------------");

        Instant instant = date.toInstant();
        System.out.println(instant.getEpochSecond());

        System.out.println("----------------------------------");

        //ofInstant(Instant, 时区)
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(dateTime);

        System.out.println("----------------------------------");

        // LocalDateTime ----> Instant ----> Date
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1);

        System.out.println("----------------------------------");

        Instant instant1 = dateTime1.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant1);

        System.out.println("----------------------------------");

        Date date1 = Date.from(instant1);
        System.out.println(date1);
    }

}
