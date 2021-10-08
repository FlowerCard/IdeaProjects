package com.huapai.exception;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 * 算术运算异常
 */
public class MyArithmeticException extends RuntimeException{
    public MyArithmeticException() {
    }

    public MyArithmeticException(String message) {
        super(message);
    }
}
