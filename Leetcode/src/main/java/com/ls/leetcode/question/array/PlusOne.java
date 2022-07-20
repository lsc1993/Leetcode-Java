package com.ls.leetcode.question.array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * <a href="https://leetcode.cn/problems/plus-one/">...</a>
 *
 * @author liushuanggo
 * @since 2022-07-20
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int value = digits[i];
            value ++;
            if (value == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] tmp = new int[len + 1];
                    tmp[0] = 1;
                    System.arraycopy(digits, 0, tmp, 1, len);
                    digits = tmp;
                    break;
                }
            } else {
                digits[i] = value;
                break;
            }
        }

        return digits;
    }
}
