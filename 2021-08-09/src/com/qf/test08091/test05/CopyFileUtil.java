package com.qf.test08091.test05;

import java.io.*;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class CopyFileUtil {

    /**
     * 复制文件
     * @param file  文件名 / 文件路径
     * @throws CopyFileException
     * @throws IOException
     */
    public void copyFile(File file) throws CopyFileException, IOException {
        String fileName = file.getName();
        int point = fileName.lastIndexOf(".");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("2021-08-09\\outsource\\" + System.currentTimeMillis()
                + fileName.substring(point, fileName.length()));
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes, 0, bytes.length)) != -1) {
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }

    /**
     * 复制文件
     * @param file      文件名 / 文件路径
     * @param charset   编码格式
     * @throws IOException
     */
    public void copyFile(File file,String charset) throws IOException {
        String fileName = file.getName();
        int point = fileName.lastIndexOf(".");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("2021-08-09\\outsource\\" + System.currentTimeMillis()
                + fileName.substring(point, fileName.length()));
        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos,charset);
        char[] chars = new char[1024];
        int len;
        while ((len = isr.read(chars, 0, chars.length)) != -1) {
            osw.write(chars,0,len);
        }
        osw.close();
        isr.close();
    }

}

