package com.ls.leetcode.questionv2.binarysearch;

public class FindMax {

    public static void main(String[] args) {
        //int[] arr = new int[]{32, 44, 72, 1, 3, 4, 10, 23, 27};
        int[] arr = new int[]{32, 1, 3, 4, 10, 23, 27};
        FindMax findMax = new FindMax();
        int index = findMax.findMaxValue(arr);

        System.out.println("index = " + index);
    }

    public int findMaxValue(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int left = 0, right = arr.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[left]) {
                right = mid;
            } else if (arr[mid] > arr[left]) {
                left = mid;
            } else if (arr[mid] == arr[left]) {
                return mid;
            }
        }

        return -1;
    }
}
