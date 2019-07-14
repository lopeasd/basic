package com.learn.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/6/12 21:47
 * @Version: 1.0
 */
public class RunnableImp implements Runnable {

    private int count = 100;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        while (true) {
            if (count > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "count= " + count--);
            }
           if(lock.isHeldByCurrentThread()){
                lock.unlock();
           }
        }
    }
}
