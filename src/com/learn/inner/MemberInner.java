package com.learn.inner;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/4/9 10:22
 * @Version: 1.0
 */

//成员内部类,不能有静态声明
public class MemberInner {

    private int i;
    public void hello(){
       MemberInner.demo1 inner = new MemberInner().new demo1();
       inner.test1();
    }

    class demo1{

        public void test1(){
            hello();
            i++;
            System.out.println("public test1");
        }

        protected void test2(){
            System.out.println(" protected test2");
        }

        void test3(){
            System.out.println(" default test3");
        }


    }
}
