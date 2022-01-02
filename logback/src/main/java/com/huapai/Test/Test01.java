package com.huapai.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author huangzihao
 * @email huangzihao@xinyunlian.com
 * Created on 2022/1/2.
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        
        Logger logger = LoggerFactory.getLogger(Test01.class);

        Random random = new Random();

        while (true) {
            int num = random.nextInt();
            if (num % 5 == 0) {
                logger.trace("trace: num is " + num);
            } else if (num % 5 == 1) {
                logger.debug("debug: num is " + num);
            } else if (num % 5 == 2) {
                logger.info("info: num is " + num);
            } else if (num % 5 == 3) {
                logger.warn("warn: num is " + num);
            } else if (num % 4 == 3) {
                logger.error("error: num is " + num);
            } 
            Thread.sleep(10);
        }
        
    }
    
}
