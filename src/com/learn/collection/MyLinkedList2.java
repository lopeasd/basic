package com.learn.collection;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/4/1 21:36
 * @Version: 1.0
 */
public class MyLinkedList2<E> {

    transient private Node firstNode;
    transient private Node lastNode;
    transient private int size = 0;

    private class Node {
        Node preNode;
        E data;
        Node nextNode;
    }
//未完善
    public void add(E e) {
        Node node = new Node();
        node.data=e;
        if (firstNode == null) {
            firstNode=node;
            lastNode= node;
        }else{
            lastNode.nextNode=node;
            node.preNode=lastNode;
            lastNode=node;
        }
        size++;
    }


    public E get(int index){

        return getNode(index).data;
    }
//为完善
    private Node getNode(int index){
        Node xNode=firstNode;
        if(firstNode!=null){
            for (int i = 0; i <index; i++) {
               xNode = xNode.nextNode;
            }
        }
        return xNode;
    }

    public void remove(int index){

    }

}
