package com.ls.leetcode.questionv2.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,9,5,1,8,4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private void sort(int[] arr, int lo, int hi, int[] tmp) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid, tmp);
            sort(arr, mid + 1, hi, tmp);
            merge(arr, lo, mid, hi, tmp);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi, int[] tmp) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = tmp[j++];
            } else if (j > hi) {
                arr[k] = tmp[i++];
            } else if (tmp[j] < tmp[i]) {
                arr[k] = tmp[j++];
            } else {
                arr[k] = tmp[i++];
            }
        }
    }
}
