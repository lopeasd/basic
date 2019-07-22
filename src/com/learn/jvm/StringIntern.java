package com.learn.jvm;

import java.util.ArrayList;
import java.util.List;

public class StringIntern {
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            List<String> list = new ArrayList<>();
            list.add("aaaaaaaaaaaaa");
        }
        System.gc();
    }

    private static void demo1() {
        //用list保持着引用 防止full gc回收常量池
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
