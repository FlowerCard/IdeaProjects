package com.huapai.dubbo.consumer;

import com.huapai.dubbo.api.DeviceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/23.
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        ioc.start();
        DeviceService deviceService = ioc.getBean(DeviceService.class);
        String deviceName = deviceService.getDeviceName(10002L);
        System.out.println("deviceName = " + deviceName);
    }
    
}
