package com.huapai.exception;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 * 索引越界异常
 */
public class MyIndexOutOfBoundsException extends RuntimeException {
    public MyIndexOutOfBoundsException() {
    }

    public MyIndexOutOfBoundsException(String message) {
        super(message);
    }
}
