package com.ls.leetcode.question.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * <a href="https://leetcode.cn/problems/roman-to-integer/">罗马数字转整数</a>
 *
 * @author liushuanggo
 * @since 2022-08-03
 */
public class RomanToInt {

    public int romanToInt(String s) {
        int len = s.length();
        Map<Character, Integer> rToNumMap = new HashMap<Character, Integer>();
        rToNumMap.put('I', 1);
        rToNumMap.put('V', 5);
        rToNumMap.put('X', 10);
        rToNumMap.put('L', 50);
        rToNumMap.put('C', 100);
        rToNumMap.put('D', 500);
        rToNumMap.put('M', 1000);

        int result = 0;
        int  lastValue = 0;
        boolean needCom = true;
        for (int i = len -1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = rToNumMap.get(c);
            if (lastValue != 0) {
                if (value < lastValue && needCom) {
                    result -= value;
                    needCom = false;
                } else {
                    result += value;
                    needCom = true;
                }
            } else {
                result += value;
            }
            lastValue = value;
        }

        return result;
    }
}
