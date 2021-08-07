package com.qf.IODemo;

import java.io.FileReader;
import java.io.IOException;

public class TestReader {
    public static void main(String[] args) {
        FileReader fr =null;
        try {
            fr = new FileReader("2021-8-6\\abc.txt");
            char[] chars = new char[20];
            int len ;
            while ((len = fr.read(chars, 0, chars.length)) != -1) {
                System.out.println(new String(chars,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
