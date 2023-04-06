package com.ls.leetcode.questionv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int index = 0;
        List<Integer> list = new ArrayList<>();
        int money = 0;
        while (in.hasNextInt()) {
            int a = in.nextInt();
            if (index == 0) {
                money = a;
                index ++;
            } else {
                list.add(a);
            }
        }
        int len = list.size();
        int[] arr = new int[len + 1];
        arr[0] = 0;
        for (int i = 0; i < len; i++) {
            arr[i + 1] = list.get(i);
        }
        int[][] dp = new int[list.size() + 1][money + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < money + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= money; j++) {
                int a = dp[i - 1][j];
                int b = 0;
                if (j >= i) {
                    b = dp[i - 1][j - i] + arr[i];
                }
                if (a > b) {
                    dp[i][j] = a;
                } else {
                    dp[i][j] = b;
                }
            }
        }
        System.out.println(dp[len][money]);
    }
}
