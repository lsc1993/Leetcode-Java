package com.ls.leetcode.questionv2.array;

/**
 * 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * https://leetcode.cn/problems/container-with-most-water
 *
 * @author liushuanggo
 * @since 2023-04-18
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int container = 0;
        while (left < right) {
            int max = Math.min(height[right], height[left]) * (right - left);
            if (container < max) {
                container = max;
            }
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }

        return container;
    }
}
