package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.binarytree.TreeNode;

import java.util.*;

public class binaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            Deque<Integer> levelList = new LinkedList<Integer>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(node.val);
                } else {
                    levelList.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }
}
