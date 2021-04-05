package com.ls.leetcode.question.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @link https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-5
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 广度优先遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> orderList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> levelList;
        while (!queue.isEmpty()) {
            levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    levelList.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!levelList.isEmpty()) {
                orderList.add(0, levelList);
            }
        }

        return orderList;
    }
}
