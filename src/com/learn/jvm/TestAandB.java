package com.learn.jvm;

//String Pool是JVM实例全局共享的，全局只有一个。
public class TestAandB {

    @org.junit.Test
    public void test(){
        System.out.println(A.a == B.a);
        System.out.println(A.b == B.b);

        A a = new A();
        B b = new B();
        System.out.println(a.c == b.c);
        System.out.println(a.d == b.d);
        System.out.println(A.a == a.c);
        System.out.println(A.b == a.d);
        String c = new String("hello");
        System.out.println(c == A.a);
        System.out.println(c.intern() == A.a);
    }
}
