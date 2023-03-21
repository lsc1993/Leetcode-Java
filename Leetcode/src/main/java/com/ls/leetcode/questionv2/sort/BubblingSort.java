package com.ls.leetcode.questionv2.sort;

/**
 * 冒泡排序
 */
public class BubblingSort {

    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 每一次遍历，就会产生一个有序元素，所以范围缩小1(也就是len - 1 - i)
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
