package com.qf.test08091.test03;

import com.qf.test08091.test03.pojo.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(10);
        user.setUserName("张三");
        user.setPassWord("123456");
        User.version = 1;

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("2021-08-09\\resource\\user.txt"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
