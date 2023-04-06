package com.ls.leetcode.questionv2;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = "";
        while (in.hasNext()) {
            word = in.next();
        }
        int[] wordNum = new int[4];
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (c == 'A') {
                wordNum[0] ++;
            } else if (c == 'D') {
                wordNum[1] ++;
            } else if (c == 'S') {
                wordNum[2] ++;
            } else if (c == 'W') {
                wordNum[3] ++;
            }
        }
        int forword = Math.abs(wordNum[0] - wordNum[1]);
        int back = Math.abs(wordNum[2] - wordNum[3]);

        System.out.println(forword + 1);
    }
}
