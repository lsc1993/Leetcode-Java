package com.ls.leetcode.questionv2.array;

/**
 * 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 *
 * @author liushuanggo
 * @since 2023-03-04
 */
public class FindMissingNumber {

    public int missingNumber(int[] nums) {
        int start = nums[0];
        if (start > 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (start != nums[i] - 1) {
                return start + 1;
            } else {
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            return start + 1;
        }
        return start;
    }
}
