package com.learn.inner;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/4/9 10:31
 * @Version: 1.0
 */
public class StaticInner {

    public void demo1() {
        Inner.test4();
    }

    static void demo2() {
        Inner.test4();
    }

    public static void main(String[] args) {
        StaticInner.Inner si = new Inner();
        StaticInner.Inner s2 = new StaticInner.Inner();
    }

    static class Inner {
        static int i = 0;

        public void test1() {
            System.out.println(" public for test1 ");
        }

        protected void test2() {
            System.out.println("protected for test2");
        }

        void test3() {
            System.out.println("default for test3");
        }

        static void test4() {
            System.out.println("Static for test2");
        }
    }
}
