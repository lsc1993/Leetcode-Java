package com.ls.leetcode.question.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串转换整数 (atoi)
 * 
 * 请你来实现一个myAtoi(string s)函数，
 * 使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
 * 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
 * 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，
 * 使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
 * 大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * https://leetcode.cn/problems/string-to-integer-atoi
 *
 * @author liushuanggo
 * @since 2022-11-5
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        boolean isNegative = false;

        int start = 0;
        char c = s.charAt(start);
        while (c == ' ') {
            start ++;
            c = s.charAt(start);
        }
        if (c == '-') {
            isNegative = true;
        } else {
            if (c >= 48 && c <= 57) {
                nums.add(c - 48);
            } else {
                return 0;
            }
        }
        start ++;
        if (start < s.length()) {
            c = s.charAt(start);
        } else {
            return cal(nums, isNegative);
        }
        while (start < s.length() && c >= 48 && c <= 57) {
            nums.add(c - 48);
            start ++;
            if (start < s.length()) {
                c = s.charAt(start);
            }
        }
        return cal(nums, isNegative);
    }

    private int cal(List<Integer> nums, boolean isNegative) {
        long result = 0;
        for (int i = nums.size() - 1, j = 0; i >=0; i--, j++) {
            int num = nums.get(i);
            result += (num * Math.pow(10, j));
        }
        if (isNegative) {
            result = -result;
            if (result < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            }
        } else {
            if (result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            }
        }
        return (int) result;
    }
}
