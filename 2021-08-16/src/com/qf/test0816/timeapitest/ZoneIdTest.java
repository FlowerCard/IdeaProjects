package com.qf.test0816.timeapitest;

import java.time.ZoneId;
import java.util.Set;

/**
 * 时区
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class ZoneIdTest {

    public static void main(String[] args) {

        //获取时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        System.out.println("----------------------------");

        //ZoneId.getAvailableZoneIds() 获取所有存在是时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds.size());
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }



    }


}
