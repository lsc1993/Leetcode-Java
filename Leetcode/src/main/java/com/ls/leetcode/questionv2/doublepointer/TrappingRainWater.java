package com.ls.leetcode.questionv2.doublepointer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * https://leetcode.cn/problems/trapping-rain-water/
 *
 * @author liushuanggo
 * @since 2023-04-11
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];

        lMax[0] = height[0];
        rMax[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        int result = 0;
        for (int i = 1; i < len; i++) {
            result += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return result;
    }

    public int trap1(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
