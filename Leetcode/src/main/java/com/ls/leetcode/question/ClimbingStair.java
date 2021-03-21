package com.ls.leetcode.question;

/**
 * 爬楼梯：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author liushuanggo@gamil.com
 * @since 2021-03-21
 */
public class ClimbingStair {

    private int climbingStair(int n) {
        int a = 0, b = 0, count = 1;

        for (int i = 1; i <= n; ++ i) {
            a = b;
            b = count;
            count = a + b;
        }

        return count;
    }
}
