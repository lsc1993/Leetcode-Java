package com.ls.leetcode.question;

import java.util.*;

public class TreeRightSideView {

    /**
     * 深度优先搜索
     * 通过栈实现，先把左子节点压栈，可以实现根据深度优先遍历右侧节点
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> rightValueAtDepth = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(0);
        int maxDepth = -1;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (node != null) {
                if (!rightValueAtDepth.containsKey(depth)) {
                    rightValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depth++;
                depthStack.push(depth);
                depthStack.push(depth);
            }
        }
        for (int i = 0; i <= maxDepth; ++i) {
            list.add(rightValueAtDepth.get(i));
        }
        return list;
    }

    /**
     * 广度优先搜索
     * 通过队列实现，从左至右依次遍历
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
