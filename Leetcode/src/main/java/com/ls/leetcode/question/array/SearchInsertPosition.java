package com.ls.leetcode.question.array;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-23
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int pos = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                pos = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (pos == -1) {
            if (left > nums.length - 1) {
                pos = left - 1;
            } else {
                if (nums[left] > target) {
                    pos = left;
                } else {
                    pos = left + 1;
                }
            }
        }

        return pos;
    }
}
