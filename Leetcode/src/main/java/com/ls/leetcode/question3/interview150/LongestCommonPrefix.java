package com.ls.leetcode.question3.interview150;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        boolean loop = true;
        StringBuilder builder = new StringBuilder();
        while (loop) {
            if (strs[0].length() <= index) {
                break;
            }
            char common = strs[0].charAt(index);
            for (String str : strs) {
                if (index >= str.length() || str.charAt(index) != common) {
                    loop = false;
                    break;
                }
            }
            if (loop) {
                builder.append(common);
                index++;
            }
        }

        return builder.toString();
    }
}
