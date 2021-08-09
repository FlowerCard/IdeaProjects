package com.qf.test08091.test02;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestInputStreamReaderAndOutputSreamWriter {
    public static void main(String[] args) {
        File file;
        Reader reader = null;
        Writer writer = null;
        try {
            file = new File("2021-08-09\\resource\\集合作业.txt");
            reader = new InputStreamReader(new FileInputStream(file));
            file = new File("2021-08-09\\outsource\\test02.txt");
            writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            char[] chars = new char[1024];
            int len;
            while ((len = reader.read(chars, 0, chars.length)) != -1) {
                writer.write(chars,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
