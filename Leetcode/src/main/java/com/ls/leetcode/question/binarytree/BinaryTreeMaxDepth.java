package com.ls.leetcode.question.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-5
 */
public class BinaryTreeMaxDepth {

    /**
     * 深度优先遍历
     */
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(maxDepth);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);

            if (node != null) {
                stack.push(node.left);
                stack.push(node.right);

                depth ++;
                depthStack.push(depth);
                depthStack.push(depth);
            }
        }

        return maxDepth;
    }

    /**
     * 广度优先遍历
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
