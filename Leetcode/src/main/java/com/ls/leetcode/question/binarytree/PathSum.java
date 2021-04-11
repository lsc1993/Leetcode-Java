package com.ls.leetcode.question.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 *
 * @link https://leetcode-cn.com/problems/path-sum
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class PathSum {

    /**
     * 广度优先遍历
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> sumList = new LinkedList<>();
        sumList.offer(root.val);

        while (!queue.isEmpty()) {
            int tmp = sumList.poll();
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
               if (tmp == targetSum) {
                   return true;
               }
               continue;
            }

            if (node.left != null) {
                sumList.offer(node.left.val + tmp);
                queue.offer(node.left);
            }

            if (node.right != null) {
                sumList.offer(node.right.val + tmp);
                queue.offer(node.right);
            }
        }

        return false;
    }

    /**
     * 递归
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }
}
