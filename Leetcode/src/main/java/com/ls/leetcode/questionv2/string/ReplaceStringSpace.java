package com.ls.leetcode.questionv2.string;

/**
 * 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-03
 */
public class ReplaceStringSpace {
    public String replaceSpace(String s) {
        //return s.replaceAll(" ", "%20");
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
