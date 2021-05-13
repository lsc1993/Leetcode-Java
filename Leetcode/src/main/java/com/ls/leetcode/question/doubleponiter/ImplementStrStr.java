package com.ls.leetcode.question.doubleponiter;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 *
 * {}@link https://leetcode-cn.com/problems/implement-strstr
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-13
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i + nLen <= hLen; ++i) {
            boolean isEqual = true;
            for (int j = 0; j < nLen; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return i;
            }
        }

        return -1;
    }
}
