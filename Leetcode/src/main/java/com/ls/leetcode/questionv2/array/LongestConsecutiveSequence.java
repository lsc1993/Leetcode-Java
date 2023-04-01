package com.ls.leetcode.questionv2.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence
 *
 * @author liushuanggo
 * @since 2023-04-02
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curLen = 1;
                int curNum = n + 1;
                while (set.contains(curNum)) {
                    curLen ++;
                    curNum ++;
                }
                longest = Math.max(longest, curLen);
            }
        }

        return longest;
    }
}
