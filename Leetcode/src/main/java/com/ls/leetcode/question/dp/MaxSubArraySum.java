package com.ls.leetcode.question.dp;

/**
 * 最大子序和
 * describe:
 *   给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author liushuanggo@gmail.com
 * @since 2021-01-05
 */
public class MaxSubArraySum {

    public static void main(String[] args) {

    }

    private static int maxSubArray(int[] nums) {
        int result = nums[0];
        int tmp = 0;
        for (int num : nums) {
            tmp = Math.max(num, tmp + num);
            result = Math.max(result, tmp);
        }

        return result;
    }
}
