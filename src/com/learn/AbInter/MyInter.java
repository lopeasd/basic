package com.learn.AbInter;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/4/3 22:48
 * @Version: 1.0
 */
//jdk1.8
public interface MyInter {
    int a = 0;//默认 public static final

    public abstract  void demo1();

    void demo2();//默认public abstract

    default int demo3(int a,int b){return a+b;}

    //1.8之后接口中也可以有main方法
    public static void main(String[] args) {

    }
}
