package com.ls.leetcode.question.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  对称二叉树
 *  给定一个二叉树，检查它是否是镜像对称的。
 *
 * @link https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-8
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
