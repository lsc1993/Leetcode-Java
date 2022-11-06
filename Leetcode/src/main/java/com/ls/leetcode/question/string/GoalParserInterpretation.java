package com.ls.leetcode.question.string;

/**
 * 设计 Goal 解析器
 *
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * https://leetcode.cn/problems/goal-parser-interpretation
 *
 * @author liushuanggo
 * @since 2022-11-6
 */
public class GoalParserInterpretation {

    public String interpret(String command) {
        int len = command.length();
        if (len < 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int left = 0, right = 0;
        while (right < len) {
            char c = command.charAt(right);
            if (c == '(') {
                right ++;
            } else if (c == ')') {
                if (right - left == 1) {
                    builder.append('o');
                }
                right ++;
                left = right;
            } else {
                if (right == left) {
                    builder.append(c);
                    right ++;
                    left ++;
                } else if (right > left) {
                    builder.append(c);
                    right ++;
                }
            }
        }

        return builder.toString();
    }
}
