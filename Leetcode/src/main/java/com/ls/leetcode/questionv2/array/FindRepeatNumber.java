package com.ls.leetcode.questionv2.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 * @author liushuanggo
 * @since 2023-03-04
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int val : nums) {
//            if (set.contains(val)) {
//                return val;
//            } else {
//                set.add(val);
//            }
//        }
//        return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
