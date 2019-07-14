package com.learn.thread;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/6/14 21:40
 * @Version: 1.0
 */
public class MyRunnableImp implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; ) {
            System.out.println(Thread.currentThread().getName()+"\t"+i++);
        }
    }
}
