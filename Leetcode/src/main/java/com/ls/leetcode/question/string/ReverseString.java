package com.ls.leetcode.question.string;

/**
 * 反转字符串
 * describe:
 *   编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *   不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *   你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * link：https://leetcode-cn.com/problems/reverse-string
 *
 * @author liushuanggo@gamil.com
 * @since 2021-01-05
 */
public class ReverseString {

    public static void main(String[] args) {

    }

    private static void reverseString(char[] s) {
        int length = s.length;
        if (length < 2) {
            System.out.println(s);
        }
        for (int i = 0; i < length / 2; ++i) {
            char tmp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = tmp;
        }
        System.out.println(s);
    }

    private static void reverseString2(char[] s) {
        int length = s.length;
        char tmp;
        for (int left = 0, right = length - 1; left < right; ++left, --right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
