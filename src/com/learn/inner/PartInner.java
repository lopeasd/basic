package com.learn.inner;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/4/9 10:42
 * @Version: 1.0
 */
//局部内部类

public class PartInner {

    public void demo1() {
        class Inner {
            public int a=0;
            public void test1() {
                System.out.println("Inner public test1");
            }

            protected void test2() {
                System.out.println("Inner protected test2");
            }

            void test3() {
                System.out.println("Inner default test3");
            }

            private void test4() {
                System.out.println("Inner private test4");
            }
        }
        Inner i = new Inner();
    }
}
