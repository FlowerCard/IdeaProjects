package com.qf.IODemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestVideo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("2021-08-06\\resource\\8.mp4");
            fos = new FileOutputStream("2021-08-06\\outsource\\" + System.currentTimeMillis() + ".mp4");
            byte[] bytes = new byte[1024];
            int len;
            long startTime = System.currentTimeMillis();
            while ((len = fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
                //fos.write(bytes);
            }
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) + "ms");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ( fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
