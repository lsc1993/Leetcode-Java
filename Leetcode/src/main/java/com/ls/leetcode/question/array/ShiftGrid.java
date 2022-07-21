package com.ls.leetcode.question.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 每次「迁移」操作将会引发下述活动：
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于grid[i][n - 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 * <a href="https://leetcode.cn/problems/shift-2d-grid/">二维网格迁移</a>
 *
 * @author liushuanggo
 * @since 2022-07-21
 */
public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = (i * n + j + k) % (m * n);
                ret.get(index1 / n).set(index1 % n, grid[i][j]);
            }
        }
        return ret;
    }
}
