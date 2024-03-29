package com.ls.leetcode.question.dp;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * <a href="https://leetcode.cn/problems/jump-game/">跳跃游戏</a>
 *
 * @author liushuanggo
 * @since 2022-07-24
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int fastest = 0;
        for (int i = 0; i < n - 1; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            if (fastest <= i) {
                return false;
            }
        }

        return fastest >= n - 1;
    }
}
