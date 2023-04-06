package com.ls.leetcode.questionv2;

import java.util.*;

public class Max2 {

    static int result = 0;
    static Deque<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = null;
        int index = 0;
        int max = 0;
        while (in.hasNextInt()) {
            int a = in.nextInt();
            if (arr == null) {
                arr = new int[a - 1];
            } else {
                if (index < arr.length) {
                    arr[index++] = a;
                } else {
                    max = a;
                }
            }
        }
        backTrace(arr, max);
        System.out.println(max);
    }

    public static void backTrace(int[] arr, int max) {
        int sum = sum();
        if (sum <= max) {
            if (max - result > max - sum) {
                result = sum;
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                continue;
            }
            list.add(arr[i]);
            backTrace(arr, max);
            list.removeLast();
        }
    }

    public static int sum() {
        int sum = 0;
        for (int n : list) {
            sum += n;
        }
        return sum;
    }
}
