package com.learn.lesson03;

/**
 * @Author: shixiaofei
 * @Description:
 * @Date: 2019/6/3 13:14
 * @Version: 1.0
 */
public class MyArray {

    public static int BinarySearch(int key, int[] a) {
        int lo = 0;
        int right = a.length - 1;
        while (lo <= right) {
            int mid = lo+(right-lo) / 2;
            if (a[mid] < key) lo = mid+1;
            else if (a[mid] > key) right = mid-1;
            else return mid;
        }
        return -1;
    }


    public static void main(String[] args) {

        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int index = MyArray.BinarySearch(7, a);
        System.out.println(index);
    }
}
