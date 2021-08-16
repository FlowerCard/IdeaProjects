package com.qf.test0816.timeapitest;

import java.time.LocalDateTime;

/**
 * 新时间API
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class NewDateTest {

    public static void main(String[] args) {

        //获取现在的时间
        LocalDateTime dateTime1 = LocalDateTime.now();
        //获取年
        int year = dateTime1.getYear();
        //获取月
        int monthValue = dateTime1.getMonthValue();
        //获取月的第几天
        int dayOfMonth = dateTime1.getDayOfMonth();
        System.out.println(year + "-" + monthValue + "-" + dayOfMonth);

        System.out.println("-------------------------------------");

        //向后加6周
        //plusXxx() 往后Xxx(日子)
        LocalDateTime dateTime2 = dateTime1.plusWeeks(6);
        System.out.println(dateTime2);

        System.out.println("-------------------------------------");

        //向前2天
        //minusXxx() 往前Xxx(日子)
        LocalDateTime dateTime3 = dateTime1.minusDays(2);
        System.out.println(dateTime3);


    }

}
