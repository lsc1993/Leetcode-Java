package com.ls.leetcode.question.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 3, 5, 6, 8};

        quickSort(array, array.length, 0, array.length - 1);

        for (int v : array) {
            System.out.print(v + " ");
        }

    }

    static void quickSort(int[] array, int length, int start, int end) {
        if (start == end) {
            return;
        }

        int index = partition(array, length, start, end);

        if (index > start) {
            quickSort(array, length, start, index - 1);
        }
        if (index < end) {
            quickSort(array, length, index + 1, end);
        }
    }

    static int partition(int[] array, int length, int start, int end) {
        if (array == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }

        int index = start;
        swap(array, index, end);

        int small = start - 1;

        for (int i = start; i < end; ++i) {
            if (array[i] < array[end]) {
                ++ small;
                if (small != i) {
                    swap(array, i, small);
                }
            }
        }

        ++ small;
        swap(array, small, end);

        return small;
    }

    static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];

        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
