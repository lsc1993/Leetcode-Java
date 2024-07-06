package com.ls.leetcode.question3.interview150;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count = 0;
        int start = 0, end = len - 1;
        while (start < end) {
            while (start < len && nums[start] != val) {
                start++;
            }
            while (end > 0 && nums[end] == val) {
                end--;
            }
            if (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
        while (len > 0) {
            if (nums[len - 1] == val) {
                count++;
            } else {
                break;
            }
            len--;
        }
        return nums.length - count;
    }

//    public int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        int left = 0;
//        for (int right = 0; right < n; right++) {
//            if (nums[right] != val) {
//                nums[left] = nums[right];
//                left++;
//            }
//        }
//        return left;
//    }
}
