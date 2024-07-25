package com.ls.leetcode.question3.interview150;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        HashSet<String> operatorSet = new HashSet<>();
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("*");
        operatorSet.add("/");
        Deque<String> stack = new LinkedList<>();
        int result = 0;
        for (String token : tokens) {
            if (operatorSet.contains(token)) {
                String value2 = stack.pop();
                String value1 = stack.pop();
                result = operator(value1, value2, token);
                stack.offerFirst(String.valueOf(result));
            } else {
                stack.offerFirst(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private int operator(String value1, String value2, String operator) {
        int v1 = Integer.parseInt(value1);
        int v2 = Integer.parseInt(value2);
        if ("+".equals(operator)) {
            return v1 + v2;
        } else if ("-".equals(operator)) {
            return v1 - v2;
        } else if ("*".equals(operator)) {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
