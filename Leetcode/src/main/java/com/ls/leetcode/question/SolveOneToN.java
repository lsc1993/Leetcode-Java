package com.ls.leetcode.question;

/**
 * 求1+2+…+n
 *
 * 求 1+2+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * @author liushuanggo@gamil.com
 * @since 2021-03-21
 */
public class SolveOneToN {

    private int sumOneToN(int n) {
        boolean flag = n > 0 && (n += sumOneToN(n - 1)) > 0;
        return n;
    }
}
