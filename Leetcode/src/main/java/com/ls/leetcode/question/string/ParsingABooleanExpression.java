package com.ls.leetcode.question.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 解析布尔表达式
 * 
 * 给你一个以字符串形式表述的布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2,
 * ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2,
 * ... 进行逻辑 或的运算（OR）
 *
 * https://leetcode.cn/problems/parsing-a-boolean-expression
 *
 * @author liushuanggo
 * @since 2022-11-05
 */
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = expression.length();
        for (int i =0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else if (val == 'f') {
                        f ++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                if (op == '!') {
                    stack.push(f == 1 ? 't' : 'f');
                } else if (op == '&') {
                    stack.push(f == 0? 't' : 'f');
                } else {
                    stack.push(t > 0? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }
}
