package com.learn.mstake;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/6/10 16:20
 * @Version: 1.0
 */

//mistake:错误

public class ThreeSum {
    static int count;
    static int count1;
    public static void main(String[] args) {
        int n=10;
        anInt(n);
        System.out.println(count1);
        System.out.println(count);
        int sum1=n*(n-1)/2;
        int sum3=(n-2)*(n-1)*n/6;
        System.out.println(sum1);
        System.out.println(sum3);
    }

    public static int count(int[] a) {
        int length = a.length;
        int cnt = 0;
        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j < length; j++) {

                for (int k = j + 1; k < length; k++) {

                    if (a[i] + a[j] + a[k] == 0) cnt++;
                }
            }
        }
        return cnt;
    }

    public static void anInt(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count1++;
                for (int k = j + 1; k < n; k++) {
                    count++;
                }
            }
        }
    }
}
