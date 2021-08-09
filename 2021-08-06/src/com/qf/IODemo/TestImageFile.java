package com.qf.IODemo;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Í¼Æ¬ÉÏ´«
 */
public class TestImageFile {
    public static void main(String[] args) {
        File file;
        FileImageInputStream fileImageInput = null;
        FileImageOutputStream fileImageOutput = null;
        try {
            file = new File("2021-08-06\\resource\\testImage.jpg");
            fileImageInput = new FileImageInputStream(file);
            fileImageOutput = new FileImageOutputStream(new File("2021-08-06\\outsource\\" + System.currentTimeMillis() + ".jpg"));
            byte[] bytes = new byte[100];
            while (fileImageInput.read(bytes, 0, bytes.length) != -1) {
                fileImageOutput.write(bytes);
                fileImageOutput.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileImageInput != null) {
                try {
                    fileImageInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileImageOutput != null) {
                try {
                    fileImageOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
