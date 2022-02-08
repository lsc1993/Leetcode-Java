package com.ls.leetcode.question.math;

/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * https://leetcode-cn.com/problems/palindrome-number
 *
 * @author liushuanggo@gamil.com
 * @since 2022-02-08
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String value = String.valueOf(x);
        int len = value.length();
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < len / 2; ++i) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(010));
    }
}
