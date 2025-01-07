package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.binarytree.TreeNode;

public class KthSmallest {

    int index = 0;
    int ans;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        index++;
        if (index == k) {
            ans = root.val;
        }
        dfs(root.right, k);
    }
}
