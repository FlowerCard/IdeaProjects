package com.qf.test08091.test05;

import java.io.File;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class TestCopyFileUtil {
    public static void main(String[] args) {
        CopyFileUtil copyFileUtil = new CopyFileUtil();
        File file = new File("2021-08-09\\resource\\ιεδ½δΈ.txt");
        try {
//            copyFileUtil.copyFile(file);
            copyFileUtil.copyFile(file,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
