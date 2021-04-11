package com.ls.leetcode.question.binarytree;

/**
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * @link https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class DiameterOfBinaryTree {

    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        bfs(root);
        return ans - 1;
    }

    /**
     * 深度优先遍历
     */
    private int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = bfs(node.left);
        int rightHeight = bfs(node.right);

        ans = Math.max(ans, leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
