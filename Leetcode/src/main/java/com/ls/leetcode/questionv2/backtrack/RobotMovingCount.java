package com.ls.leetcode.questionv2.backtrack;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 *
 * @author liushuanggo
 * @since 2023-03-29
 */
public class RobotMovingCount {

    int[][] board;
    int res = 0;

    public int movingCount(int m, int n, int k) {
        board = new int[m][n];
        dfs(m, n, k, 0, 0);
        return res;
    }


    private void dfs(int m, int n, int k, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 1) {
            // 超出索引边界
            return;
        }
        if (i % 10 + i / 10 % 10 + j % 10 + j / 10 % 10 > k) {
            return;
        }
        // 将当前的点用特殊值覆盖，防止被重复访问
        board[i][j] = 1;
        res++;
        dfs(m, n, k, i - 1, j);
        dfs(m, n, k, i + 1, j);
        dfs(m, n, k, i, j - 1);
        dfs(m, n, k, i, j + 1);
    }
}
