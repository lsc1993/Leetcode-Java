package com.ls.leetcode.question.doubleponiter;

/**
 * 长度最小的子数组
 * 
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * https://leetcode.cn/problems/minimum-size-subarray-sum
 *
 * @author liushuanggo
 * @since 2022-11-2
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int result = 0;
        int len = 0;
        int minLen = 0;
        while (right < nums.length) {
            result += nums[right];
            len ++;
            right ++;
            if (result >= target) {
                if (minLen == 0 || minLen > len) {
                    minLen = len;
                }
            }

            while (result >= target) {
                result -= nums[left];
                len --;
                left ++;
                if (result >= target) {
                    if (minLen == 0 || minLen > len) {
                        minLen = len;
                    }
                }
            }
        }

        return minLen;
    }
}
