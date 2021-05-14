package com.ls.leetcode.question.array;

/**
 * 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * {}@link https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-15
 */
public class MergeSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1;
        int pos2 = n - 1;
        int tail = m + n - 1;

        while (pos1 >= 0 || pos2 >= 0) {
            if (pos1 == -1) {
                nums1[tail] = nums2[pos2--];
            } else if (pos2 == -1) {
                nums1[tail] = nums1[pos1--];
            } else if (nums1[pos1] > nums2[pos2]) {
                nums1[tail] = nums1[pos1--];
            } else {
                nums1[tail] = nums2[pos2--];
            }
            tail--;
        }
    }
}
