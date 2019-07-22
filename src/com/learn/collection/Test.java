package com.learn.collection;

import java.util.LinkedList;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/3/30 9:27
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("abc");
        Object remove = linkedList.remove();
        System.out.println(remove);
        System.out.println(linkedList.size());
    }

    private static void demo2() {
        MyLinkedList2 myLinkedList = new MyLinkedList2();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Object a = myLinkedList.get(0);
        Object b = myLinkedList.get(1);
        Object o = myLinkedList.get(2);
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("0:" + o);
    }

    private static void demo1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        System.out.println("size=" + myLinkedList.size());
        Object a = myLinkedList.get(0);
        Object b = myLinkedList.get(1);
        Object c = myLinkedList.get(2);
        Object d = myLinkedList.get(3);
        System.out.println("0:" + a + "\t" + "1:" + b + "\t" + "2:" + c + "\t" + "3:" + d);
    }
}
