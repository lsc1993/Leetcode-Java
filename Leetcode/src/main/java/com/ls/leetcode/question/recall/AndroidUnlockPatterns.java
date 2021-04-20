package com.ls.leetcode.question.recall;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 安卓系统手势解锁
 * 我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。
 * 用户可以设置一个 “解锁模式” ，通过连接特定序列中的点，形成一系列彼此连接的线段，
 * 每个线段的端点都是序列中两个连续的点。如果满足以下两个条件，则 k 点序列是有效的解锁模式.
 *
 * {}@link https://leetcode-cn.com/problems/android-unlock-patterns
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-20
 */
public class AndroidUnlockPatterns {

    private HashMap<Integer, Pair> posMap = new HashMap<>();
    private int[][] numbers = new int[3][3];
    int result = 0;
    public int numberOfPatterns(int m, int n) {
        if (n < 1) {
            return 0;
        }
        int val = 1;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                numbers[i][j] = val;
                posMap.put(val, new Pair(i, j));
                val ++;
            }
        }

        for (int i = m; i <= n; ++i) {
            dfs(i, new ArrayDeque<>());
        }
        return result;
    }

    private void dfs(int size, Deque<Integer> deque) {
        if (deque.size() == size) {
            result ++;
            return;
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int val = numbers[i][j];
                if (deque.contains(val)) {
                    continue;
                }
                if (deque.size() > 0) {
                    int last = deque.getLast();
                    int midVal = isValidLink(last, val);
                    if (midVal == -1 || deque.contains(midVal)) {
                        deque.addLast(val);
                    } else {
                        continue;
                    }
                } else {
                    deque.addLast(val);
                }
                dfs(size, deque);
                deque.removeLast();
            }
        }
    }

    private int isValidLink(int num1, int num2) {
        Pair pair1 = posMap.get(num1);
        Pair pair2 = posMap.get(num2);

        int left = pair1.a + pair2.a;
        int right = pair1.b + pair2.b;

        if ((left % 2 == 0) && (right % 2 == 0)) {
            return numbers[left / 2][right / 2];
        }

        return -1;
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    //  官方解法
    private boolean used[] = new boolean[9];

    public int numberOfPatterns2(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++) {
            res += calcPatterns(-1, len);
            for (int i = 0; i < 9; i++) {
                used[i] = false;
            }
        }
        return res;
    }

    private boolean isValid(int index, int last) {
        // index 与 last 相等
        if (used[index])
            return false;
        // 表示第一个数字
        if (last == -1)
            return true;
        // 相邻的行或列
        if ((index + last) % 2 == 1)
            return true;
        // 间隔一行或一列
        int mid = (index + last)/2;
        if (mid == 4)
            return used[mid];
        // 斜对角
        if ((index%3 != last%3) && (index/3 != last/3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }

    private int calcPatterns(int last, int len) {
        if (len == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last)) {
                used[i] = true; // 记录已经使用过的元素
                sum += calcPatterns(i, len - 1);
                used[i] = false; // 回溯
            }
        }
        return sum;
    }
}
