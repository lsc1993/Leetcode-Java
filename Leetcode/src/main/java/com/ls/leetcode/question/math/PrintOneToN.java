package com.ls.leetcode.question.math;

public class PrintOneToN {

    public static void main(String[] args){
        printOneToNDigits(3);
    }

    static void printOneToNDigits(int n) {
        if (n <= 0) {
            System.out.println("0");
        }
        char[] number = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        boolean isOverflow = false;
        while (!isOverflow) {
            int takeOver = 0;
            for (int i = n - 1; i >= 0; --i) {
                int sum = number[i] - '0' + takeOver;
                if (i == n -1) {
                    sum ++;
                }
                if (sum >= 10) {
                    if (i == 0) {
                        isOverflow = true;
                        number[i] = '0';
                    } else {
                        number[i] = '0';
                        takeOver = 1;
                    }
                } else {
                    number[i] = (char) ('0' + sum);
                    break;
                }
            }
            printNumber(number);
        }
    }

    static void printNumber(char[] number) {
        boolean highIsZero = true;
        for (char value : number) {
            if (!highIsZero) {
                System.out.print(value);
            }
            if (value != '0' && highIsZero) {
                System.out.print(value);
                highIsZero = false;
            }
        }
        System.out.println();
    }
}
