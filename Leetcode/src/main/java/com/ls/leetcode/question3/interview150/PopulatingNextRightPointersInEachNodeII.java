package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.model.TreeNextNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

    public TreeNextNode connect(TreeNextNode root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        Queue<TreeNextNode> queue = new LinkedList<>();
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            TreeNextNode last = null;
            for (int i = 1; i <= sz; ++i) {
                TreeNextNode f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}
