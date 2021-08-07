package com.qf.test08031.test02;

import java.util.Iterator;
import java.util.LinkedList;

public class Test02 {
    public static void main(String[] args) {
        LinkedList<Student> linkedList = new LinkedList();
        linkedList.add(new Student("刘德华",85));
        linkedList.add(new Student("张学友",100));
        linkedList.add(new Student("刘杰",65));
        linkedList.add(new Student("章子怡",58));
        linkedList.add(new Student("周迅",6));

        System.out.println(linkedList.size());
        System.out.println(linkedList);
        for (int i = 0; i < linkedList.size(); i++) {
            Student s = linkedList.get(i);
            if (s.getName().equals("刘杰")) {
                linkedList.remove(i);
//                i--;
            }
//            if (s.getName().equals("刘德华")) {
//                s.setScore(95);
//            }
            if (linkedList.get(i).getScore() < 60) {
                System.out.println(s);
            }
        }
        for (Student s : linkedList) {
            if (s.getName().equals("刘德华")) {
                s.setScore(95);
            }
        }
        System.out.println(linkedList);
//        for (int i = 0; i < linkedList.size(); i++) {
//            if (student1.equals(linkedList.get(i))){
//                linkedList.remove(i);
//            }
//            if (student2.equals(linkedList.get(i))){
////                linkedList.set(i,new Student("刘德华",95));
//
//            }
//            student3 = (Student) linkedList.get(i);
//            if (student3.getScore() < 60) {
//                System.out.println(linkedList.get(i));
//            }
//        }
//        System.out.println(linkedList);
    }
}
