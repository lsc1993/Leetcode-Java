package com.ls.leetcode.question;

import com.ls.leetcode.util.Log;

/**
 * Two Sum
 *
 * describe:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * simple:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @see {linktourl https://leetcode-cn.com/problems/two-sum/description/}
 *
 * @author liushuang
 */
public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int len = nums.length - 1;
        for (int i = 0;i < len; ++i) {
            for (int j = i + 1;j < len + 1; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void testTwoSum() {
        int[] nums = new int[]{2, 6, 7, 9};
        int target = 9;
        int[] result = TwoSum.twoSum(nums, target);
        Integer[] r = new Integer[2];
        if (result != null) {
            r[0] = result[0];
            r[1] = result[1];
        } else {
            r = null;
        }
        Log.printArray(r);
    }
}
