package com.ls.leetcode.question.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @link https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-9
 */
public class ValidBinarySearchTree {

    /**
     * 中序遍历相当于降序列表
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        double inOrder = -Double.MAX_VALUE;
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.val <= inOrder) {
                return false;
            }
            inOrder = root.val;
            root = root.right;
        }

        return true;
    }
}
