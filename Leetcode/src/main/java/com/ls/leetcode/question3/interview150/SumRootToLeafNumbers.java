package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        List<Integer> numList = new ArrayList<>();
        num.offer(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            int val = num.poll();
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                numList.add(val);
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                num.offer(node.left.val + val * 10);
            }
            if (node.right != null) {
                queue.offer(node.right);
                num.offer(node.right.val + val * 10);
            }
        }
        int sz = numList.size();
        int sum = 0;
        for (int i = 0; i < sz; i++) {
            sum += numList.get(i);
        }

        return sum;
    }
}
