package com.ls.leetcode.question3.interview150;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String name : array) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty()) {
            builder.append("/");
        } else {
            while (!stack.isEmpty()) {
                builder.append("/");
                builder.append(stack.pollFirst());
            }
        }
        return builder.toString();
    }
}
