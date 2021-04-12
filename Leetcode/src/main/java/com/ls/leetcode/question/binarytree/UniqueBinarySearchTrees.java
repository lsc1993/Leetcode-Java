package com.ls.leetcode.question.binarytree;

/**
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * {}@link https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-12
 */
public class UniqueBinarySearchTrees {

    /**
     * 动态规划
     * 设： 二叉搜索树的数量是 g(n)
     * f(i, n) 表示在以 i 为节点，长度为 n 的二叉树的数量
     * 那么 f(i, n) = g(i - 1) * g(n - i)
     * 又：g(n) = ∑ f(i, n)
     * 所以：
     * g(n) = ∑ g(i - 1) * g(n - i)
     */
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++ j) {
                g[i] += g[j - 1] * g[i - j];
            }
        }

        return g[n];
    }
}
