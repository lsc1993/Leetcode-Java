package com.ls.leetcode.question;

import com.ls.leetcode.util.Log;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 *
 * describe:
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * simple:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 *
 * @see {linktourl https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/}
 *
 * @author liushuang
 */
public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len <= 0) {
            return 0;
        }

        int subStrLen = 1;
        int tempLen = 1;
        int start = 0;
        for (int i = 0;i < len - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (tempLen < subStrLen) {
                    tempLen = subStrLen;
                }
                subStrLen = 1;
                start = i + 1;
            } else {
                int index;
                if ((index = s.substring(start, i + 1).indexOf(s.charAt(i + 1))) != -1) {
                    if (tempLen < subStrLen) {
                        tempLen = subStrLen;
                    }
                    if (index == i) {
                        subStrLen = 1;
                        start = i + 1;
                    } else {
                        subStrLen -= index;
                        start = index + start + 1;
                    }
                } else {
                    subStrLen ++;
                }
            }
        }
        return tempLen > subStrLen? tempLen : subStrLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int ans = 0;
        int rs = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rs < len && !set.contains(s.charAt(rs))) {
                set.add(s.charAt(rs));
                ++ rs;
            }
            ans = Math.max(rs - i, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "wobgrovw";
        String s3 = "ggububgvfk";

        int l1 = lengthOfLongestSubstring2(s1);
        int l2 = lengthOfLongestSubstring2(s2);
        int l3 = lengthOfLongestSubstring2(s3);

        Log.logLn("result:" + s1 + "->" + l1 + " " + s2 + "->" + l2 + " " + s3 + "->" + l3);
    }
}
