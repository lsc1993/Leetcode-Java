package com.ls.leetcode.question.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * <a href="https://leetcode.cn/problems/daily-temperatures">每日温度</a>
 *
 * @author liushuanggo
 * @since 2022-07-31
 */
public class DailyTemperatures {

    public int[] dailyTemperatures111(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int next = 1;
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = next;
                    break;
                } else {
                    next ++;
                }
            }
        }

        return result;
    }

    /**
     * 单调栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
