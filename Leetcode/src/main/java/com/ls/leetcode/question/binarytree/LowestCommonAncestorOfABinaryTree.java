package com.ls.leetcode.question.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @link https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class LowestCommonAncestorOfABinaryTree {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bfs(root, p, q);
        return ans;
    }

    private boolean bfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lSon = bfs(root.left, p, q);
        boolean rSon = bfs(root.right, p, q);

        if ((lSon && rSon) || ((root.val == p.val || root.val == q.val) && (lSon || rSon))) {
            ans = root;
        }

        return (lSon && rSon) || (root.val == p.val || root.val == q.val);
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    private void bfs2(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            bfs2(root.left);
        }

        if (root.right != null) {
            parent.put(root.right.val, root);
            bfs2(root.right);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        bfs2(root);

        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }

        return null;
    }
}
