package com.qf.IODemo;

import java.io.File;
import java.util.Arrays;

public class TestFile {
    public static void main(String[] args) throws  Exception{
        File file1 = new File("2021-8-6\\jdbc.properties");
        File file2 = new File("E:\\VNC");
        File file3 = new File("2021-8-6\\a.txt");
//        File.separator  根据操作系统动态提供分隔符

        System.out.println(file1.getName());
        System.out.println(file2.getName());
        System.out.println("----------------");

        System.out.println(file1.getParent());
        System.out.println(file2.getParent());
        System.out.println("----------------");

        System.out.println(file1.getPath());
        System.out.println(file2.getPath());
        System.out.println("----------------");

        //绝对路径
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println("----------------");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file2.getAbsoluteFile());
        System.out.println("----------------");

        //删除文件  只能删除空目录
//        System.out.println(file1.delete());
//        System.out.println(file2.delete());

        //是否可以执行的文件
        System.out.println(file1.canExecute());
        System.out.println(file2.canExecute());
        System.out.println("----------------");
        //是否可读
        System.out.println(file1.canRead());
        System.out.println(file2.canRead());
        System.out.println("----------------");

        System.out.println(file3.createNewFile());
        System.out.println("----------------");

        //是否为空
        System.out.println(file1.exists());
        System.out.println(file2.exists());
        System.out.println("-------11---------");

        System.out.println(file1.isFile());
        System.out.println(file2.isDirectory());
        System.out.println("----------------");

        System.out.println(file1.length());
        System.out.println(file2.length());
        System.out.println("----------------");

        //改名
        //System.out.println(file1.renameTo(new File("b.properties")));

        //输出文件夹下所有的文件
        System.out.println(Arrays.toString(file1.list()));
        System.out.println(Arrays.toString(file2.list()));
        System.out.println(Arrays.toString(file2.listFiles()));


    }
}
