package com.ls.leetcode.questionv2.array;

/**
 * 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-04
 */
public class SearchRepeatNumInSortArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                right = middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return 0;
        }
        int total = 1;
        for (int i = left; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                total++;
            } else {
                break;
            }
        }
        return total;
    }
}
