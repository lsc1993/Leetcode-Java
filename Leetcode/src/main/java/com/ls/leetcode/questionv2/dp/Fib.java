package com.ls.leetcode.questionv2.dp;

/**
 * 斐波那契数列
 *
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-08
 */
public class Fib {

    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] %= 1000000007;
        }

        return d[n];
    }
}
