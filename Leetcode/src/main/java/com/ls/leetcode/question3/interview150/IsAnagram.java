package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        HashMap<Character, Integer> sCountMap = new HashMap<>();
        HashMap<Character, Integer> tCountMap = new HashMap<>();

        for (int i = 0; i < sLen; i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            int sCount = sCountMap.getOrDefault(sc, 0);
            int tCount = tCountMap.getOrDefault(tc, 0);
            sCountMap.put(sc, ++sCount);
            tCountMap.put(tc, ++tCount);
        }
        for (Character c : sCountMap.keySet()) {
            int sCount = sCountMap.get(c );
            Integer tCount = tCountMap.get(c);
            if (tCount == null || sCount != tCount) {
                return false;
            }
        }
        return true;
    }
}
