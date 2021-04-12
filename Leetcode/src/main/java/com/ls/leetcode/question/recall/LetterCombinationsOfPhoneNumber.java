package com.ls.leetcode.question.recall;

import java.util.*;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * {}@link https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-12
 */
public class LetterCombinationsOfPhoneNumber {

    private Map<Integer, String[]> numberMap = new HashMap<>();
    {
        numberMap.put(2, new String[] {"a", "b", "c"});
        numberMap.put(3, new String[]{"d", "e", "f"});
        numberMap.put(4, new String[]{"g", "h", "i"});
        numberMap.put(5, new String[] {"j", "k", "l"});
        numberMap.put(6, new String[]{"m", "n", "o"});
        numberMap.put(7, new String[]{"p", "q", "r", "s"});
        numberMap.put(8, new String[] {"t", "u", "v"});
        numberMap.put(9, new String[]{"w", "x", "y", "z"});
    }
    List<String> strList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return strList;
        }
        backTrack(digits, new StringBuilder(), 0);
        System.out.println(strList);
        return strList;
    }

    private void backTrack(String digits, StringBuilder str, int index) {
        if (digits.length() == index) {
            strList.add(str.toString());
        } else {
            char val = digits.charAt(index);
            String[] nums = numberMap.get(val - 48);
            for (String num : nums) {
                str.append(num);
                backTrack(digits, str, index + 1);
                str.deleteCharAt(index);
            }
        }
    }
}
