package com.learn.jvm.GC;

public class SerialExample {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte [] allo1=new byte[2 * _1MB];
        byte [] allo2=new byte[2 * _1MB];
        byte [] allo3=new byte[2 * _1MB];
        byte [] allo4=new byte[4 * _1MB];
    }
}
