package com.qf.test08091.test01;

import java.io.*;

public class TestBufferedInputStreamAndBufferedOutputStream {
    public static void main(String[] args) {
        File file;
        InputStream is;
        OutputStream ot;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            file = new File("2021-08-09\\resource\\集合作业.txt");
            is = new FileInputStream(file);
            bis = new BufferedInputStream(is);
            file = new File("2021-08-09\\outsource\\test.txt");
            ot = new FileOutputStream(file);
            bos = new BufferedOutputStream(ot);
            byte[] bytes = new byte[1024];
            while (bis.read(bytes, 0, bytes.length) != -1) {
                bos.write(bytes);
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
