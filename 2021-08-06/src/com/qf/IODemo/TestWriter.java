package com.qf.IODemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void main(String[] args) {
        FileWriter fw = null;
        try{
            fw = new FileWriter(new File("2021-8-6\\a.txt"));
            fw.write("中国np");
            fw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
