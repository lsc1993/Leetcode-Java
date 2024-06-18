package com.ls.leetcode.question3.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TowSumIII {

    List<Integer> array = new ArrayList<>();

    boolean isSorted = false;

    public TowSumIII() {

    }

    public void add(int number) {
        array.add(number);
        isSorted = false;
    }

    public boolean find(int value) {
        if (!isSorted) {
            Collections.sort(array);
        }
        int left = 0, right = array.size() - 1;
        while (left < right) {
            int leftValue = array.get(left);
            int rightValue = array.get(right);
            int result = leftValue + rightValue;
            if (result < value) {
                left++;
            } else if (result > value) {
                right++;
            } else {
                return true;
            }
        }
        return false;
    }
}
