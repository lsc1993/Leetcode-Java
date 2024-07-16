package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int len = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            end++;
            int count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
            while (map.get(ch) > 1) {
                char ch1 = s.charAt(start);
                start++;
                int c = map.getOrDefault(ch1, 0);
                map.put(ch1, --c);
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
}
