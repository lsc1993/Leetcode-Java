package com.ls.leetcode.questionv2.binarytree;

import com.ls.leetcode.question.binarytree.TreeNode;

/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * @author liushuanggo
 * @since 2023-03-25
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
       return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }

            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }

        return true;
    }
}
