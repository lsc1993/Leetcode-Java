package com.ls.leetcode.question3.interview150;

public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(area, max);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
