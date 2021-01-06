package com.ls.leetcode.question;

import java.util.*;

public class TreeRightSideView {

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
        for (int i = 0; i < maxDepth; ++i) {
            list.add(rightValueAtDepth.get(i));
        }
        return list;
    }

    private void listTreeRight(TreeNode right, List<Integer> list) {
        if (right != null) {
            list.add(right.val);
            if (right.right != null) {
                listTreeRight(right.right, list);
            } else {
                listTreeRight(right.left, list);
            }

        }
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
