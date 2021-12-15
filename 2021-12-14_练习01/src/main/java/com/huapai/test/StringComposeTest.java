package com.huapai.test;

import org.junit.Test;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/14.
 * 字符串压缩
 */
public class StringComposeTest {
    
    @Test
    public void stringComposeTest01() {
        StringBuffer result = new StringBuffer();
        String str = "aavvcccsssb";
        int c = 1;

        for (int i = 0; i <= str.length() - 1; i++) {
            
            if (i !=str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                c++;
            } else {
                if (c != 1) {
                    result.append(c);
                }
                result.append(str.charAt(i));
                c = 1;
            }
            
        }
        System.out.println("result = " + result);

    }
    
}
