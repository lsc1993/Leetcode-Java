package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            char c = t.charAt(i);
            Character ch = map.get(c);
            if (ch == null) {
                char sCh = s.charAt(i);
                if (map.containsValue(sCh)) {
                    return false;
                }
                map.put(c, sCh);
                builder.append(s.charAt(i));
            } else {
                builder.append(ch);
            }
        }
        String str = builder.toString();
        return s.equals(str);
    }
}
