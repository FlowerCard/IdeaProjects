package com.huapai.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/16.
 */
public class Test01 {
    
    @Test
    public void test02() {
        int[] num1 = {1,2,3,4,5,10};
        int[] num2 = {2,5,6,1,8,10};
        
    }
    
    @Test
    public void test01() {
        int[] num1 = {1,2,3,4,5,10};
        int[] num2 = {2,5,6,1,8,10};
        Arrays.sort(num1);
        Arrays.sort(num2);
        int[] result = getIntersection(num1,num2);
        System.out.println(Arrays.toString(result));
    }

    public int[] getIntersection(int []aArray,int []bArray) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < aArray.length; i++) {
            for (int j = 0; j < bArray.length; j++) {
                if (aArray[i] == bArray[j]) {
                    list.add(aArray[i]);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
