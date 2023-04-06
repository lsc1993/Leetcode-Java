package com.ls.leetcode.questionv2;

import java.util.Arrays;
import java.util.Scanner;

public class MaxElement {
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
        Arrays.sort(arr);
        int left = 0, right = 0;
        int sum = 0;
        while (right < arr.length) {
            sum += arr[right];
            right ++;
            if (sum == max) {
                break;
            } else if (sum < max) {

            } else {
                while (sum > max) {
                    sum -= arr[left];
                    left ++;
                }
                if (left >= right || sum == 0) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
