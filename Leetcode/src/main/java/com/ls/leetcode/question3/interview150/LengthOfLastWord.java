package com.ls.leetcode.question3.interview150;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int len = 0;
        int index = s.length() - 1;
        boolean hasWord = false;
        while (index >= 0) {
            char c = s.charAt(index);
            if (c != ' ') {
                hasWord = true;
                len++;
            } else {
                if (hasWord) {
                    break;
                }
            }
            index --;
        }
        return len;
    }
}
