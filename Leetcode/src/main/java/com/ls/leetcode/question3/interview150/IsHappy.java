package com.ls.leetcode.question3.interview150;

import java.util.HashSet;

public class IsHappy {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextN(n);
        }
        return n == 1;
    }

    private int getNextN(int n) {
        int totalNum = 0;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            totalNum += num * num;
        }
        return totalNum;
    }
}
