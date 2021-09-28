package com.huapai.advice;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 * 事务增强类
 */
public class TransactionAdvice {
    
    public void begin(){
        System.out.println("事务开启...");
    }
    
    public void commit(){
        System.out.println("事务提交...");
    }
    
    public void rollback(){
        System.out.println("事务回滚...");
    }
    
    public void release(){
        System.out.println("资源释放...");
    }
    
    public void around(){
        System.out.println("环绕通知...");
    }
    
}
