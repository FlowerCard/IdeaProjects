package com.huapai.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 * 事务增强类
 */
@Component
@Aspect
public class TransactionAdvice {
    
    @Pointcut("execution(* com.huapai.service.impl..*(..))")
    public void pt(){}
    
    @Before(value = "pt()")
    public void begin(){
        System.out.println("事务开启...");
    }
    
//    @AfterReturning(value = "pt()") Spring-AOP注解开发的bug，本来应该使用这个
    @After(value = "pt()")
    public void commit(){
        System.out.println("事务提交...");
    }
    
    @AfterThrowing(value = "pt()")
    public void rollback(){
        System.out.println("事务回滚...");
    }
    
//    @After(value = "pt()") Spring-AOP注解开发的bug，本来应该使用这个
    @AfterReturning(value = "pt()")
    public void release(){
        System.out.println("资源释放...");
    }
    
//    @Around(value = "pt()")
    public void around(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        try {
            System.out.println("事务开启...携带参数 ===> " + (args==null?null: Arrays.toString(args)));

            for (int i = 0; i < 10; i++) {
                int random = new Random().nextInt(10);
                if (6 == random) {
                    System.out.println(10/0);
                }
            }

            System.out.println("事务提交");
        } catch (Exception e) {
            System.err.println("事务回滚 ===> " + e.getMessage());
        } finally {
            System.out.println(joinPoint.getSignature().getName() + "方法结束，释放资源");
        }
    }
    
}
