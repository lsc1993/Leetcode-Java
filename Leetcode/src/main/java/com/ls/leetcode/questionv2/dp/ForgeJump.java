package com.ls.leetcode.questionv2.dp;

/**
 * 青蛙跳台阶问题
 *
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/submissions/
 *
 * @author liushuanggo
 * @since 2023-03-08
 */
public class ForgeJump {

    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
