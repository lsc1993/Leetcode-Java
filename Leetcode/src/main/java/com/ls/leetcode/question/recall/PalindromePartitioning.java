package com.ls.leetcode.question.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * {}@link https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-14
 */
public class PalindromePartitioning {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // 动态规划预处理回文串
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; ++j) { // 选择列表
            if (f[i][j]) { // 排除不合法选择
                ans.add(s.substring(i, j + 1)); // 做选择
                dfs(s, j + 1); // 进入下一行决策
                ans.remove(ans.size() - 1); // 撤销选择
            }
        }
    }
}
