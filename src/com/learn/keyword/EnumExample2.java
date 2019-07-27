package com.learn.keyword;

/*
 * Enum 一般用来表示一组相同类型的常量。如：性别、日期、月份、颜色等。
 * 对这些属性用常量的好处是显而易见的，不仅可以保证单例，且在比较的时候可以用 ”==” 来替换 equals。
 * 在 JDK1.5 之前是没有 Enum 这个类型的，那时候一般用接口常量来替代。*/
public enum EnumExample2 {
    MON, TUE, WED, THU, FRI, SAT, SUN;

    public static void main(String[] args) {
        for (EnumExample2 e2 : EnumExample2.values()
        ) {
            System.out.println(e2);
        }
    }
}
