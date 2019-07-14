package com.learn.lesson01;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/3/26 21:19
 * @Version: 1.0
 */
public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            elementData = EMPTY_ELEMENTDATA;
        } else if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("容量不能为负数" + "Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public void add(Object object) {

        if (size > elementData.length) {
            throw new IllegalArgumentException("shuzu越界");
        } else if (size == elementData.length) {

            int newCapacity = size + size >> 1;
            Object[] newData = new Object[newCapacity];

            System.arraycopy(elementData, 0, newData, 0, elementData.length);
            elementData = newData;
        }
        elementData[size++] = object;
    }

    public Object get(int index) {
        if (index >= 0 && index < elementData.length) {
            return elementData[index];
        } else throw new IllegalArgumentException("索引越界 ");
    }

    public int size() {
        return elementData.length;
    }

    public Object remove(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new IllegalArgumentException("索引越界 ");
        } else {
            Object removeData=elementData[index];
           System.arraycopy(elementData,index+1,elementData,index,elementData.length-index-1);
            elementData[--size]=null;
            return removeData;
        }
    }
}
