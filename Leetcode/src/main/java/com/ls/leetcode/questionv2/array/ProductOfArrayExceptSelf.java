package com.ls.leetcode.questionv2.array;

/**
 * 除自身以外数组的乘积
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * https://leetcode.cn/problems/product-of-array-except-self
 *
 * @author liushuanggo
 * @since 2023-04-10
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < len; i++) {
            L[i] = L[i] * R[i];
        }

        return L;
    }
}
