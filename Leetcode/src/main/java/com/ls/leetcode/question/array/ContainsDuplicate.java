package com.ls.leetcode.question.array;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 。
 * 如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * <a href="https://leetcode.cn/problems/contains-duplicate/">存在重复元素</a>
 *
 * @author liushuanggo
 * @since 2022-08-01
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == nums[left + 1]) {
                return true;
            }
            if (nums[right] == nums[right - 1]) {
                return true;
            }
            left ++;
            right --;
        }

        return false;
    }
}
