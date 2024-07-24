package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        int pLen = pattern.length();
        String[] array = s.split(" ");
        int sLen = array.length;
        if (pLen != sLen) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();
        for (int i = 0; i <pLen; i++) {
            Character c = pattern.charAt(i);
            String word = array[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (map.containsValue(word)) {
                    Character ch = wordMap.get(word);
                    if (c != ch) {
                        return false;
                    }
                }
                map.put(c, word);
                wordMap.put(word, c);
            }
        }
        return true;
    }
}
