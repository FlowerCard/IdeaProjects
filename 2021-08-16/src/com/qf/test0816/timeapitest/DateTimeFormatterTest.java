package com.qf.test0816.timeapitest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式化类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class DateTimeFormatterTest {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();

        //时间 ---> String
        String format = dateTime.format(formatter);
        System.out.println(format);

        System.out.println("----------------------------");

        // String ---> 时间
        String time = "1999-11-11 16:20:33";
        LocalDateTime parse = LocalDateTime.parse(time, formatter);
        System.out.println(parse);

    }

}
