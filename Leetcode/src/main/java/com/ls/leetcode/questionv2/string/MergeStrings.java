package com.ls.leetcode.questionv2.string;

/**
 * 交替合并字符串
 *
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 *
 * https://leetcode.cn/problems/merge-strings-alternately
 *
 * @author liushuanggo
 * @since 2023-04-18
 */
public class MergeStrings {

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i++));
            }
            if (j < n) {
                ans.append(word2.charAt(j++));
            }
        }
        return ans.toString();
    }
}
