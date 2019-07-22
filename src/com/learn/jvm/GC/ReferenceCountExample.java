package com.learn.jvm.GC;

/**
 * 引用计数算法的缺陷
 * testGC()方法执行后，objA，和objB 会不会被gc收集
 * VM Option：-XX:+PrintGCDetails
 */
public class ReferenceCountExample {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    //属性意义是占用内存。方便查看GC日志是否被回收.
    private byte [] bigSize=new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountExample objA = new ReferenceCountExample();
        ReferenceCountExample objB = new ReferenceCountExample();
        objA.instance=objB;
        objB.instance=objA;
        objA=null;
        objB=null;

        //假设发生gc时，objA,objB 能否被回收
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
