package com.ls.leetcode.question3.interview150;

public class ZConvert {

    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = 2 * numRows - 2;
        int c = (n + t - 1) / t * (numRows - 1);
        char[][] mat = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            char cc = s.charAt(i);
            mat[x][y] = cc;
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
