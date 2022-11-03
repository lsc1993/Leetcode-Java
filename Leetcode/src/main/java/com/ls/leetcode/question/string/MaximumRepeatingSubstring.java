package com.ls.leetcode.question.string;

import java.util.Arrays;

/**
 * 最大重复子字符串
 *
 * 你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，
 * 那么单词word 的 重复值为 k 。单词 word的 最大重复值是单词word在sequence中最大的重复值。
 * 如果word不是sequence的子串，那么重复值k为 0 。
 * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
 *
 * https://leetcode.cn/problems/maximum-repeating-substring
 *
 * @author liushuanggo
 * @since 2022-11-4
 */
public class MaximumRepeatingSubstring {

    public int maxRepeating1(String sequence, String word) {
        int k = 0;
        if (!sequence.contains(word)) {
            return k;
        }
        int m = sequence.length();
        int n = word.length();
        while (m >= n) {
            int index = sequence.indexOf(word);
            if (index >= 0) {
                k++;
            }
            sequence = sequence.substring(index + n);
            m = sequence.length();
        }
        return k;
    }

    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }

        int[] f = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
}
