package com.ls.leetcode.questionv2.string;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 *
 * @author liushuanggo
 * @since 2023-03-03
 */
public class ReverseStringLeftWords {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] array = new char[len];
        for (int i = 0; i < len; i++) {
            if (i < n) {
                array[len - n + i] = s.charAt(i);
            } else {
                array[i - n] = s.charAt(i);
            }
        }
        return new String(array, 0, len);
    }
}
