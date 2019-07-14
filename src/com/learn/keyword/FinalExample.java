package com.learn.keyword;

public class FinalExample {

    public static int test() {
        try {
            throw new IllegalAccessException("exception.....");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static void main(String[] args) {
        //断言1结果为true，则继续往下执行
        assert true;
        System.out.println("断言1没有问题，Go！");

        System.out.println("\n-----------------\n");

        //断言2结果为false,程序终止
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");
    }

}
