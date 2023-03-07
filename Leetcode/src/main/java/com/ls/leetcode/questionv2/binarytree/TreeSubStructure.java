package com.ls.leetcode.questionv2.binarytree;

import com.ls.leetcode.question.binarytree.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-07
 */
public class TreeSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
