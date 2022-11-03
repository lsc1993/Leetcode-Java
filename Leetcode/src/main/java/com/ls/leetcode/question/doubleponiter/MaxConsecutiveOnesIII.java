package com.ls.leetcode.question.doubleponiter;

/**
 * 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，
 * 如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * https://leetcode.cn/problems/max-consecutive-ones-iii/
 *
 * @author liushuanggo
 * @since 2022-11-3
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes1(int[] nums, int k) {
        int right = 0, left = 0;
        int tmp = k;
        int maxLen = 0;
        int len = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                len ++;
            } else {
                if (tmp > 0) {
                    len ++;
                    tmp --;
                }
            }
            right ++;
            if (len > maxLen) {
                maxLen = len;
            }
            while (tmp <= 0) {
                if (nums[left] == 0) {
                    tmp ++;
                }
                left ++;
                len --;
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
