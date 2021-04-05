package com.ls.leetcode.question.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> listNodes = new ArrayList<>();
        traversalTree(root, listNodes);
        return listNodes;
    }

    private void traversalTree(TreeNode node, List<Integer> listNodes) {
        if (node == null) {
            return;
        }
        traversalTree(node.left, listNodes);
        listNodes.add(node.val);
        traversalTree(node.right, listNodes);
    }

    private List<Integer> iteratorTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> listNodes = new ArrayList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            listNodes.add(root.val);
            root = root.right;
        }

        return listNodes;
    }
}
