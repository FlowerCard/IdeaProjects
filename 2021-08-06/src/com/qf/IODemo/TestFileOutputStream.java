package com.qf.IODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //创建文件和管道流
            fos = new FileOutputStream(new File("2021-8-6\\abc.txt"));
            fos.write("ascbx".getBytes());
            //fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
