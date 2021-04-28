package com.ls.leetcode.question.dp;

/**
 * 青蛙跳台阶问题
 *
 * describe:
 * 一只青蛙一次可以跳1级台阶，也可以跳2级台阶。如果跳n级台阶总共有多少种跳法。
 */
public class FrogJumpStep {

    public static void main(String[] args) {
        for (int i = 1; i < 60; ++i) {
            System.out.println(frogJumpStep2(i));
        }
    }

    static int frogJumpStep(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return frogJumpStep(n - 1) + frogJumpStep(n - 2);
    }

    static int frogJumpStep2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000_000_007;
        }
        return dp[n];
    }
}
