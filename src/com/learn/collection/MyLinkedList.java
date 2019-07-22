package com.learn.collection;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/3/30 9:24
 * @Version: 1.0
 */
public class MyLinkedList {

    Node head = null;
    private int size;

    public boolean add(Object object) {

        Node node = new Node(object);
        if (head == null) {
            head = node;
            size++;
            node.next = null;
        } else {
            Node temp;
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = null;
            size++;
        }
        return true;
    }

    public Object get(int index) {
        Node temp = head;
        if (index == 0) {
            return head;
        } else if (index > 0 && index < size) {
            for (int i = 0; i <= (index - 1); i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IllegalArgumentException("索引越界");
        }


    }

    public Object remove(int index) {
        if (index < 0 && index > this.size()) {
            throw new IllegalArgumentException("索引越界 ");
        } else {
            Node temp = head;
            while (head != null) {
                if (size == index) {

                    return temp;
                }
                temp = temp.next;
                size++;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

}
