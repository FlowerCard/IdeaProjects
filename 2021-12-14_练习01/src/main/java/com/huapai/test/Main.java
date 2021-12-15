package com.huapai.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/14.
 */
class Solution {
    
    static long sum = 0;

    public long twoThreadsCalculateSigmaI(long n) {
        CountDownLatch latch = new CountDownLatch(2);

        try {
            ExecutorService service = Executors.newFixedThreadPool(2);

            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j < n/2; j++) {
                        sum += j;
                    }
                    latch.countDown();
                }
            });
            
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 50; j <= n; j++) {
                        sum += j;
                    }
                    latch.countDown();
                }
            });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return sum;
    }

}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        // use two threads to accelerate the calculation of Σi
        System.out.println(s.twoThreadsCalculateSigmaI(100));
        // the printed number should be 5050
    }
    
}
