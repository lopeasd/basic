package com.learn.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/7/11 13:12
 * @Version: 1.0
 */
public class ArraysTest {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");
        for (String s:strings
             ) {
            System.out.println(s);
        }
        System.out.println(System.getProperty("java.version"));
        String s ="world";
        s+="hello";
    }



}
