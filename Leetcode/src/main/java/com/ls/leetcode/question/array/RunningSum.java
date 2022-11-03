package com.ls.leetcode.question.array;

/**
 * 一维数组的动态和
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 * https://leetcode.cn/problems/running-sum-of-1d-array
 *
 * @author liushuanggo
 * @since 2022-11-2
 */
public class RunningSum {

    public int[] runningSum(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return new int[]{};
        }
        int[] result = new int[len];
        result[0] = nums[0];
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
