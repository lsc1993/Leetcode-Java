package com.ls.leetcode.question.doubleponiter;

/**
 * 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * {}@link https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-12
 */
public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 1;
        int end = 1;

        for (int i = 0; i < nums.length; ++i) {
            if (end < nums.length && nums[end - 1] != nums[end]) {
                nums[start] = nums[end];
                start ++;
            }
            end ++;
        }
        return start;
    }
}
