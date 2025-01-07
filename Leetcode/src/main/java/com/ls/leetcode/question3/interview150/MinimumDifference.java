package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.binarytree.TreeNode;

public class MinimumDifference {

    int pre, ans;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(root.val - pre));
        }
        pre = root.val;
        dfs(root.right);
    }
}
