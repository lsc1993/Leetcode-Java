package com.ls.leetcode.question;

/**
 * 实现数值的整数次方
 * describe:
 *     实现函数double Power(double base, int exponent),求base的exponent次方,不能使用库函数
 */
public class DoublePower {

    public static void main(String[] args) {
        System.out.println(doublePower(123.23, -1));
    }

    static double doublePower(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            return 0.0;
        }

        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }

        double result = powerWithExponent(base, absExponent);

        if (exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    static double powerWithExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1;i <= exponent; ++ i) {
            result *= base;
        }

        return result;
    }

    static double powerWithExponent1(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }

        if (exponent == 1) {
            return base;
        }

        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            return result * base;
        }

        return result;
    }

    static boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 > 0.0000001)) {
            return true;
        }

        return false;
    }
}
