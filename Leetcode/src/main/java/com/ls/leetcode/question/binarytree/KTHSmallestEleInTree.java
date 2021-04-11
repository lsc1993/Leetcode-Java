package com.ls.leetcode.question.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @link https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class KTHSmallestEleInTree {

    /**
     * 中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();

        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (root != null) {
                k --;
                if (k == 0) {
                    return root.val;
                }
            }
            root = root.right;
        }

        return -1;
    }
}
