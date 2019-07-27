package com.learn.test;

/**
 * @Description  clinit方法
 * @Author shixiaofei
 * @Date 2019/7/26 10:33
 * @Version 1.0
 */
public class ClinitTest {
  /*  static {
        i = 0;                // 给变量赋值可以正常编译通过
        System.out.print(i);  // 这句编译器会提示“非法向前引用” illegal forward reference
    }
    static int i = 1;*/
  static class Parent {
      public static int A = 1;
      static {
          A = 2;
      }
  }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);  // 2
    }
}
