package com.ls.leetcode.question.doubleponiter;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * {}@link https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-16
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase();
        int start = 0;
        int end = len - 1;
        while (start < end) {
            char sChar = s.charAt(start);
            while (!Character.isLetterOrDigit(sChar)) {
                start ++;
                if (start >= len) {
                    return true;
                }
                sChar = s.charAt(start);
            }

            char eChar = s.charAt(end);
            while (!Character.isLetterOrDigit(eChar)) {
                end --;
                if (end < 0) {
                    return true;
                }
                eChar = s.charAt(end);
            }

            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
