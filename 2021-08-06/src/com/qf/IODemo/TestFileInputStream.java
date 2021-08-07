package com.qf.IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        //1.准备文件和管道流
        try {
            fis = new FileInputStream(new File("2021-8-6\\jdbc.properties"));
            //2.读取文件内容
            byte[] bytes = new byte[100];
            int len = -1;
            while ((len = fis.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                //3.关闭流
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
