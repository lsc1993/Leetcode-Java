package com.ls.leetcode.question.binarytree;

import java.util.*;

/**
 * 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * @link https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class FindLargestValueInTree {

    /**
     * 广度优先->层序遍历
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.val > max) {
                        max = node.val;
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            list.add(max);
        }

        return list;
    }
}
