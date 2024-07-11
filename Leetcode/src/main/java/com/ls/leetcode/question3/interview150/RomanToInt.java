package com.ls.leetcode.question3.interview150;

import java.util.HashMap;

public class RomanToInt {

    public int romanToInt(String s) {
        HashMap<Character, Integer> numMap = new HashMap<>();
        numMap.put('I', 1);
        numMap.put('V', 5);
        numMap.put('X', 10);
        numMap.put('L', 50);
        numMap.put('C', 100);
        numMap.put('D', 500);
        numMap.put('M', 1000);

        int len = s.length();
        int index = len - 1;
        int sum = 0;
        while (index >= 0) {
            char right = s.charAt(index);
            char left;
            int rightValue = numMap.get(right);
            int leftValue = 0;
            if (index - 1 >= 0) {
                left = s.charAt(index - 1);
                leftValue = numMap.get(left);
            }
            if (leftValue < rightValue) {
                sum += (rightValue - leftValue);
                index--;
            } else {
                sum += rightValue;
            }
            index--;
        }
        return sum;
    }
}
