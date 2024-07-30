package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.binarytree.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
