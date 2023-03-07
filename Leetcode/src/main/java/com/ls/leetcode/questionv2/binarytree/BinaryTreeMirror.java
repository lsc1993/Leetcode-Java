package com.ls.leetcode.questionv2.binarytree;

import com.ls.leetcode.question.binarytree.TreeNode;

/**
 * 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-07
 */
public class BinaryTreeMirror {

    public TreeNode mirrorTree(TreeNode root) {
       if (root == null) {
           return null;
       }
       change(root);
       return root;
    }

    private void change(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;
        change(node.left);
        change(node.right);
    }
}
