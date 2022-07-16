package com.ls.leetcode.question.array;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。
 * 请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 *
 * <a href="https://leetcode.cn/problems/3sum-closest">...</a>
 *
 * @author liushuanggo
 * @since 2022-07-16
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; ++i) {
            int value = target - nums[i];
            int last = twoSum(nums, i + 1, value);
            int v = last + nums[i] - target;
            if (Math.abs(best) > Math.abs(v)) {
                result = last + nums[i];
                best = v;
            }
        }
        return result;
    }

    private int twoSum(int[] nums, int start, int target) {
        int end = nums.length - 1;
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        while (start < end) {
            int left = nums[start];
            int right = nums[end];
            int sum = left + right;
            int gap = target - sum;
            if (Math.abs(gap) < Math.abs(minGap)) {
                minGap = gap;
                result = sum;
            }
            if (sum == target) {
                minGap = 0;
                result = sum;
                while (start < end && nums[start] == left) start ++;
                while (start < end && nums[end] == right) end --;
            } else if (sum < target) {
                start ++;
            } else {
                end --;
            }
        }

        return result;
    }

    public int otherSolution(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
