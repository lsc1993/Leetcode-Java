package com.ls.leetcode.question3.interview150;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.isBlank()) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;
        int len = t.length();
        while (tIndex < len) {
            char sch = s.charAt(sIndex);
            if (sch == t.charAt(tIndex)) {
                if (sIndex == s.length() - 1) {
                    return true;
                }
                sIndex++;
            }
            tIndex++;
        }
        return false;
    }
}
