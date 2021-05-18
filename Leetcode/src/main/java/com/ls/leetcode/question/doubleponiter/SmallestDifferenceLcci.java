package com.ls.leetcode.question.doubleponiter;

import java.util.Arrays;

/**
 * 最小差
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * https://leetcode-cn.com/problems/smallest-difference-lcci/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-18
 */
public class SmallestDifferenceLcci {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0,j = 0;
        long min = Long.MAX_VALUE;

        while (i < a.length && j <b.length) {
            if (a[i] == b[j]) return 0;
            else if (a[i] > b[j]) {
                min = Math.min(min,(long) a[i] -(long) b[j]);
                j ++;
            } else {
                min = Math.min(min,(long) b[j] -(long) a[i]);
                i ++;
            }
        }
        return (int)min;
    }
}
