package com.ls.leetcode.question.sort;

/**
 * 归并排序
 *
 * @author liushuanggo@gmail.com
 * date: 2019-8-21
 */
public class MergeSort {
    public static void main(String[] args) {
        int array[] = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        int tmp[] = new int[array.length];
        mergeSort(array, tmp, 0, array.length - 1);

        for (int value : array) {
            System.out.print(value + "->");
        }

    }

    static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    static void merge(int a[], int tmp[], int left, int center, int right) {
        int leftEnd = center - 1;
        int num = right - left + 1;
        int temPos = left;

        while (left <= leftEnd && center <= right) {
            if (a[left] < a[center]) {
                tmp[temPos ++] = a[left ++];
            } else {
                tmp[temPos ++] = a[center ++];
            }
        }

        while (left <= leftEnd) {
            tmp[temPos ++] = a[left ++];
        }

        while (center <= right) {
            tmp[temPos ++] = a[center++];
        }

        //从末尾向a数组复制已排序的数组tmp
        for (int i = 0; i < num; i ++, right --) {
            a[right] = tmp[right];
        }
    }
}
