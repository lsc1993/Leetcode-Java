package com.ls.leetcode.questionv2.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * @author liushuanggo
 * @since 2023-03-15
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            Integer num = map.getOrDefault(c, 0);
            num ++;
            map.put(c, num);
            while (map.getOrDefault(c, 0) > 1) {
                char d = s.charAt(left);
                left ++;
                int v = map.getOrDefault(d, 0);
                v --;
                if (v < 0) {
                    v = 0;
                }
                map.put(d, v);
            }
            length = Math.max(length, right - left);
        }
        return length;
    }
}
