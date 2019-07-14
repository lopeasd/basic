package com.learn.thread;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/6/14 21:29
 * @Version: 1.0
 */
public class MyThread extends java.lang.Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; ) {
            System.out.println(Thread.currentThread().getName()+"\t"+i++);
        }
    }
}
