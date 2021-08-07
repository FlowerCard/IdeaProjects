package com.qf.test08021.test03;

public class Test03 {
    public static void main(String[] args) {
        String str1;
        str1 = "abkkcadkabkebfkabkskab";
        int count = 0;
        int index = 0;
        while ((index = str1.indexOf("ab",index)) != -1) {
            count++;
            index+="ab".length();
        }
        System.out.println(count);
    }
}
