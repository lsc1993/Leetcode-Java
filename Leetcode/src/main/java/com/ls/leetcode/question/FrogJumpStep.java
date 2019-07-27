package com.ls.leetcode.question;

/**
 * 青蛙跳台阶问题
 *
 * describe:
 * 一只青蛙一次可以跳1级台阶，也可以跳2级台阶。如果跳n级台阶总共有多少种跳法。
 */
public class FrogJumpStep {

    public static void main(String[] args) {
        for (int i = 1; i < 6; ++i) {
            System.out.println(frogJumpStep(i));
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
}
