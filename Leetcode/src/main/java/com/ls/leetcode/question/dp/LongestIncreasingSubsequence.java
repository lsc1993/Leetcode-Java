package com.ls.leetcode.question.dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * {}@link https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-25
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int max = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < len; ++i) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
