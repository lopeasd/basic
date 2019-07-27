package com.learn.jvm.GC;

/**
 * @Description 结合jvm参数，测试GC回收
 * @Author shixiaofei
 * @Date 2019/7/25 18:47
 * @Version 1.0
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[31744*1024];
        //allocation2 = new byte[900*1024];
    }
}
