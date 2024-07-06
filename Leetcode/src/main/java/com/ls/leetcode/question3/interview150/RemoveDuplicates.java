package com.ls.leetcode.question3.interview150;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0, right = 1;
        while (right < len) {
            if (nums[right] != nums[left]) {
                if (right - left > 1) {
                    left++;
                    nums[left] = nums[right];
                } else {
                    left++;
                }
            }
            right++;
        }
        return left + 1;
    }
}
