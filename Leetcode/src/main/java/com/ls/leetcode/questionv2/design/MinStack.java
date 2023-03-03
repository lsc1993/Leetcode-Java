package com.ls.leetcode.questionv2.design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
