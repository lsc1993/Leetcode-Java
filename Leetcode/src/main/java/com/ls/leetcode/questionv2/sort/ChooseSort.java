package com.ls.leetcode.questionv2.sort;

public class ChooseSort {

    public void sort(int[] arr) {
        int len = arr.length;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i; j < len - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 记录目前能找到的最小值元素的下标
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
