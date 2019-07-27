package com.learn.keyword;

/*
 *。当定义一个枚举类型时，
 * 每一个枚举类型成员都可以看作是 Enum 类的实例，
 * 这些枚举成员默认都被 final、public, static 修饰
 *
 */
public enum EnumExample {

    A("100-90"), B("89-80"), C("79-70"), D("69-60"), E("59-0");
    private String s;

    EnumExample(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public static void main(String[] args) {
        for (EnumExample e : EnumExample.values()
        ) {
            System.out.println(e + ":" + "\t" + e.getS() + "\t" + e.name());
        }
    }
}
