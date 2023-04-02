package com.ls.leetcode.questionv2.binarytree;

import com.ls.leetcode.question.binarytree.TreeNode;

/**
 * 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 * @author liushuanggo
 * @since 2023-04-02
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
