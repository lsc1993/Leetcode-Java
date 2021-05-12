package com.ls.leetcode.question.dp;

import java.util.*;

/**
 * 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * {}@link https://leetcode-cn.com/problems/largest-divisible-subset
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-12
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        Set<Integer> result = new HashSet<>();

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0 && maxSize > 0; --i) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                result.add(nums[i]);
                maxVal = nums[i];
                maxSize --;
            }
        }

        return new ArrayList<>(result);
    }
}
