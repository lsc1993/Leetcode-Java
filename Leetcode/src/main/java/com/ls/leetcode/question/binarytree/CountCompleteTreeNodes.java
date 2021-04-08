package com.ls.leetcode.question.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * @link https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-8
 */
public class CountCompleteTreeNodes {

    /**
     * 广度优先遍历
     */
    public int countNodes(TreeNode root) {
        int nodeCount = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node;
            for (int i = 0; i < size; ++i) {
                node = queue.poll();
                if (node != null) {
                    nodeCount ++;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return nodeCount;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
