package com.ls.leetcode.question.dp;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * {}@link https://leetcode-cn.com/problems/unique-paths
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-25
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths p = new UniquePaths();
        p.uniquePaths(3, 7);
    }

    //  回溯算法  超时
    private int total = 0;
    public int uniquePaths(int m, int n) {
        step(m, n, 1, 1);

        System.out.println("total: " + total);
        return total;
    }

    private void step(int m, int n, int right, int down) {
        if (right == m && down == n) {
            total ++;
        } else {
            if (right < m) {
                right ++;
                step(m, n, right, down);
                right --;
            }

            if (down < n) {
                down ++;
                step(m, n, right, down);
                down --;
            }
        }
    }

    // 动态规划
    public int uniquePaths2(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }
}
