package com.learn.thread;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/6/14 21:30
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        RunnableImp runnableImp = new RunnableImp();
        Thread t1 = new Thread(runnableImp);
        Thread t2 = new Thread(runnableImp);
        Thread t3 = new Thread(runnableImp);
        t1.start();
        t2.start();
        t3.start();
    }
}
