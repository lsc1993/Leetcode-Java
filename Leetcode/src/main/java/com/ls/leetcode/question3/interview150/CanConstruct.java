package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> rCountMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int count = rCountMap.getOrDefault(c, 0);
            rCountMap.put(c, ++count);
        }

        HashMap<Character, Integer> mCountMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int count = mCountMap.getOrDefault(c, 0);
            mCountMap.put(c, ++count);
        }

        for (char c : rCountMap.keySet()) {
            int rCount = rCountMap.getOrDefault(c, 0);
            int mCount = mCountMap.getOrDefault(c, 0);
            if (mCount < rCount) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
