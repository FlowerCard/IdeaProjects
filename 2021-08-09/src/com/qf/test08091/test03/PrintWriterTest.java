package com.qf.test08091.test03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("2021-08-09\\outsource\\info.txt");
        //print方法：原样输出
        writer.print(97);
        writer.print('a');
        writer.println();
        writer.println();

        //write方法：会把数字通过ASCII码转成字符
        writer.write(97);
        writer.write('a');
        writer.println();
        writer.write("中华人民共和国");

        writer.close();

    }
}
