package com.ls.leetcode.question3.interview150;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0, right = 1;
        while (right < len) {
            if (nums[right] != nums[left]) {
                if (right - left > 2) {
                    left = left + 2;
                    nums[left] = nums[right];
                } else {
                    left = right;
                }
            }
            right++;
        }
        return left + 1;
    }
}
