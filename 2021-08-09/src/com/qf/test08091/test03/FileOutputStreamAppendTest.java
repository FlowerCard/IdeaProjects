package com.qf.test08091.test03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class FileOutputStreamAppendTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("2021-08-09\\outsource\\fos.txt",true);
        fos.write("asdfsdfdf".getBytes());
        fos.close();
    }
}
