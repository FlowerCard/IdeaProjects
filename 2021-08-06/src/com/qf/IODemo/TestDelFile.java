package com.qf.IODemo;

import java.io.File;

public class TestDelFile {
    public void DelFile(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if (f.isFile()) {
                f.delete();
            } else if (f.isDirectory()) {
                    DelFile(f);
            }
        }
        //文件删除之后，直接删除文件夹
        file.delete();
    }

    public static void main(String[] args) {
        TestDelFile td = new TestDelFile();
        td.DelFile(new File("e:\\aaa"));
    }
}
