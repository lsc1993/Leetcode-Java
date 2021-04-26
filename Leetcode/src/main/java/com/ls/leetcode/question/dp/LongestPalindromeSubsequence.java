package com.ls.leetcode.question.dp;

/**
 * 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * {}@link https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * @author liushuanggo@gamil.com
 * @since 2021-4-26
 */
public class LongestPalindromeSubsequence {

    /**
     * 状态转移方程
     * if s[i] == s[j]
     *   dp[i][j] = dp[i + 1][j - 1] + 2
     * else
     *   dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
     *
     * dp[i][j - 1]      dp[i][j](结果)
     * dp[i + 1][j - 1]  dp[i + 1][j]
     * 斜着遍历，一直到求出结果
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; ++i) {
            dp[i][i] = 1;
        }

        // 斜着遍历
        for (int i = len - 2; i >=0; --i) {
            for (int j = i + 1; j < len; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
