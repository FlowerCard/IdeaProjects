package com.huapai.advice;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 */
public class LoggerAdvice {
    Logger logger = LoggerFactory.getLogger(Logger.class);
    
    public void begin(JoinPoint joinpoint){
        String name = joinpoint.getSignature().getName();
        Object[] args = joinpoint.getArgs();
        Object target = joinpoint.getTarget();
        logger.debug(target + " ===> " + name + " ===> 方法执行，开启日志记录 " + (args==null?null: Arrays.toString(args)));
    }
}
