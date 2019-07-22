package com.learn.collection;

/**
 * @Author: shixiaofei
 * @Description:链表的实现
 * @Date: 2019/3/30 9:24
 * @Version: 1.0
 */
public class Node {

    Object data;
    Node next=null;
    public Node(Object data){this.data=data;}

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
