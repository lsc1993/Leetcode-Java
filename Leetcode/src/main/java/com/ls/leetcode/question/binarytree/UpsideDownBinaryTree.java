package com.ls.leetcode.question.binarytree;

/**
 * 上下翻转二叉树
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，
 * 要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 *
 * @link https://leetcode-cn.com/problems/binary-tree-upside-down
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class UpsideDownBinaryTree {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) { // root为空或是叶子节点返回
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left); // 只需递归处理左子树，不需要递归右子树，右子树都是叶子节点

        root.left.left  = root.right; // 三角关系翻转
        root.left.right = root;

        // 根或子树的root变为右叶子节点
        root.left = null; // 注意，题解说：所有右节点，都是叶子节点，且有兄弟节点。所以，root旋转后，都会变为右叶子节点，所以left和right设为null。估计很多人看漏了这个条件，感觉莫名其妙。我自己还模拟右子节点还有两个子节点的情况，想了半天。。
        root.right = null;
        return newRoot; // 同链表翻转，返回整颗树最左的叶子节点
    }
}
