package com.java2105.huangzihao.test02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class BookTest {

    public static void main(String[] args) {
        HashMap<Integer,Book> map = new HashMap<>();

        Book book1 = new Book(1001,"三国演义",60.0);
        Book book2 = new Book(1002,"西游记",30.0);

        map.put(book1.getBookNum(), book1);
        map.put(book2.getBookNum(), book2);

        System.out.println("书籍信息如下：");
        System.out.println("书号\t书名\t价格");
        System.out.println(map.get(book1.getBookNum()));
        System.out.println(map.get(book2.getBookNum()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的书籍编号：");
        int bookNumin = scanner.nextInt();
        if (map.get(bookNumin) != null) {
            System.out.print("请输入新书名：");
            String newName = scanner.next();
            System.out.print("请输入新价格：");
            Double newPrice = scanner.nextDouble();
            map.put(bookNumin,new Book(bookNumin,newName,newPrice));
        } else {
            System.out.println("要修改的书不存在");
        }

        System.out.println("修改后的书籍信息如下：");
        System.out.println("书号\t书名\t价格");
        System.out.println(map.get(book1.getBookNum()));
        System.out.println(map.get(book2.getBookNum()));

    }

}
