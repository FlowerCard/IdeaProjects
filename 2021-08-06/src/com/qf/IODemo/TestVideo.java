package com.qf.IODemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestVideo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:\\课件\\2021-8-6\\视频\\3-自定义异常.mp4");
            fos = new FileOutputStream("E:\\课件\\2021-8-6\\视频\\3-b.mp4");
            byte[] bytes = new byte[1024];
            int len;
            long startTime = System.currentTimeMillis();
            while ((len = fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
                //fos.write(bytes);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime);
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
