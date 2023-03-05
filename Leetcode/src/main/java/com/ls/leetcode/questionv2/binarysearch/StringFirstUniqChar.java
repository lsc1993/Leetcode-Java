package com.ls.leetcode.questionv2.binarysearch;

/**
 * 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author liushuanggo
 * @since 2023-03-05
 */
public class StringFirstUniqChar {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) count[c - 'a']++;
        for (char c : chars) {
            if (count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
