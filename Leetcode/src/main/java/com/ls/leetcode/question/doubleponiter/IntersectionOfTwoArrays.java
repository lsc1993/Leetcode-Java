package com.ls.leetcode.question.doubleponiter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-16
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length - 1;
        int len2 = nums2.length - 1;
        Set<Integer> result = new HashSet<>();

        while (len1 >= 0 && len2 >= 0) {
            if (nums1[len1] > nums2[len2]) {
                len1 --;
            } else if (nums1[len1] < nums2[len2]) {
                len2 --;
            } else {
                result.add(nums1[len1]);
                len1 --;
                len2 --;
            }
        }

        int[] array = new int[result.size()];
        int i = 0;
        for (int val : result) {
            array[i++] = val;
        }
        return array;
    }
}
