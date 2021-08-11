package com.qf.test0811.test01;

import java.util.concurrent.Callable;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyCallable implements Callable<Integer> {

    /**
     * 计算 1 - 50 的和
     * @return  计算结果
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 1; i < 51; i++) {
            sum += i;
        }
        return sum;
    }
}
