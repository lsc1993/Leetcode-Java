package com.ls.leetcode.question3.interview150;

public class MergeTwoArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start1 = m - 1;
        int start2 = n - 1;
        int index = m + n - 1;
        while (start1 >= 0 && start2 >= 0) {
            int value1 = nums1[start1];
            int value2 = nums2[start2];
            if (value1 > value2) {
                nums1[index] = value1;
                start1--;
            } else {
                nums1[index] = value2;
                start2--;
            }
            index--;
        }
        if (start2 >= 0) {
            while (start2 >= 0) {
                nums1[index] = nums2[start2];
                start2--;
                index--;
            }
        }
    }
}
