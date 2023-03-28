package com.ls.leetcode.questionv2.doublepointer;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-28
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{nums[start], nums[end]};
            } else if (sum > target) {
                end --;
            } else {
                start ++;
            }
        }

        return null;
    }
}
