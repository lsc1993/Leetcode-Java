package com.ls.leetcode.question.array;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-23
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int pos = nums.length - k;
        return nums[pos];
    }
}
