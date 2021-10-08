package com.huapai.exception;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 * 格式化异常
 */
public class MyFormattingException extends RuntimeException{
    public MyFormattingException() {
    }

    public MyFormattingException(String message) {
        super(message);
    }
}
