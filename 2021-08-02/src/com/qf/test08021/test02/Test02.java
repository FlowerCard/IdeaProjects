package com.qf.test08021.test02;

public class Test02 {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("ab[cdef]g");
        System.out.println(str1);
        StringBuilder str2;
        str2 = new StringBuilder(str1.substring(3, 7));
        str2.reverse();
        str1.replace(3,7,str2.toString());
        System.out.println(str1);
    }
}
