package com.ls.leetcode.question.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root。
 * 设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 * <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree">最大层内元素和</a>
 *
 * @author lishuanggo
 * @since 2022-07-31
 */
public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int level = 0;
        int maxLevel = 1;
        int sum = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int curSum = 0;
            boolean isHaveNode = false;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                isHaveNode = true;
                curSum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
            level ++;
            if (curSum > sum && isHaveNode) {
                sum = curSum;
                maxLevel = level;
            }
        }

        return maxLevel;
    }
}
