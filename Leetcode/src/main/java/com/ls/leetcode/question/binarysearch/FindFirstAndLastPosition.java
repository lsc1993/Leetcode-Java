package com.ls.leetcode.question.binarysearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author liushuang
 * @since 2022-12-26
 */
public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == nums.length) {
            result[0] = -1;
        } else {
            result[0] = nums[left] == target? left : -1;
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left - 1 < 0) {
            result[1] = -1;
        } else {
            result[1] = nums[left - 1] == target? left - 1 : -1;
        }
        return result;
    }
}
