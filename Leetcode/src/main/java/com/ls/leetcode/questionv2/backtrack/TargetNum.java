package com.ls.leetcode.questionv2.backtrack;

/**
 * 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * https://leetcode.cn/problems/target-sum
 *
 * @author liushuanggo
 * @since 2023-03-20
 */
public class TargetNum {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, target, 0, 0);
        return count;
    }

    private void backTrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count ++;
            }
        } else {
            backTrack(nums, target, index + 1, sum + nums[index]);
            backTrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
