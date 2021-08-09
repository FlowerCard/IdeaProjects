package com.qf.test08091.test03;

import com.qf.test08091.test03.pojo.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("2021-08-09\\resource\\user.txt"));

            Object object = ois.readObject();
            if (object instanceof User) {
                User user = (User) object;
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
