package com.ls.leetcode.question.dp;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths p = new UniquePaths();
        p.uniquePaths(3, 7);
    }

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
}
