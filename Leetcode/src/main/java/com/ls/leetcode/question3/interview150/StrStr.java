package com.ls.leetcode.question3.interview150;

public class StrStr {

    public int strStr(String haystack, String needle) {
        int left = 0, right = needle.length();
        int len = haystack.length();
        while (right <= len) {
            String subStr;
            if (right == len) {
                subStr = haystack.substring(left);
            } else {
                subStr = haystack.substring(left, right);
            }
            if (subStr.equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }
}
