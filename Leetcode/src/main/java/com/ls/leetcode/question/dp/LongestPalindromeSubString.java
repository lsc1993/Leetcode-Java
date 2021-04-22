package com.ls.leetcode.question.dp;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @{}link https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author liushuanggo@gamil.com
 * @since 2021-4-23
 */
public class LongestPalindromeSubString {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] f = new boolean[length][length];
        for (int i = 0; i < length; ++i) {
            f[i][i] = true;
        }

        int max = 1;
        int begin = 0;
        char[] array = s.toCharArray();
        for (int i = 2; i <= length; ++i) {
            for (int j = 0; j < length; ++j) {
                int end = i + j - 1;
                if (end >= length) {
                    break;
                }

                if (array[j] != array[end]) {
                    f[j][end] = false;
                } else {
                    if (end - j < 3) {
                        f[j][end] = true;
                    } else {
                        f[j][end] = f[j + 1][end - 1];
                    }
                }

                if (f[j][end] && end - j + 1 > max) {
                    max = end - j + 1;
                    begin = j;
                }
            }
        }

        return s.substring(begin, begin + max);
    }
}
