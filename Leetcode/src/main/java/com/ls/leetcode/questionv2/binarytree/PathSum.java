package com.ls.leetcode.questionv2.binarytree;

import com.ls.leetcode.question.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> sumQueue = new LinkedList<>();
        sumQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = sumQueue.poll();
            if (node.left == null && node.right == null) {
                if (value == targetSum) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
                sumQueue.offer(node.left.val + value);
            }
            if (node.right != null) {
                queue.offer(node.right);
                sumQueue.offer(node.right.val + value);
            }
        }

        return false;
    }
}
