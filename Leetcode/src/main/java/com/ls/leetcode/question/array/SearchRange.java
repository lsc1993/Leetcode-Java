package com.ls.leetcode.question.array;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">在排序数组中查找元素的第一个和最后一个位置</a>
 *
 * @author liushuanggo
 * @since 2022-07-21
 */
public class SearchRange {

    public int[] searchRange1(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = length - 1;
        int l = -1;
        int r = -1;
        boolean shiftLeft = true;
        boolean shiftRight = true;
        while (left <= right) {
            if (nums[left] == target) {
                if (shiftLeft) {
                    l = left;
                } else {
                    r = left;
                    left ++;
                }
                shiftLeft = false;
            } else if (nums[left] < target) {
                left ++;
            }
            if (nums[right] == target) {
                if (shiftRight) {
                    r = right;
                }
                shiftRight = false;
            } else if (nums[right] > target) {
                right --;
            } else if (nums[right] < target) {
               break;
            }
            if (!shiftLeft && !shiftRight) {
                break;
            }
        }

        return new int[]{l, r};
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (lower) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (lower) {
            return left;
        } else {
            return left - 1;
        }
    }
}
