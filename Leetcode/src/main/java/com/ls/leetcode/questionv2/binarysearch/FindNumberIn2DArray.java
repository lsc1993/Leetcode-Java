package com.ls.leetcode.questionv2.binarysearch;

/**
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
 * 每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * @author liushuanggo
 * @since 2023-03-05
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int[] nums = matrix[i];
            if (binarySearch(nums, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
