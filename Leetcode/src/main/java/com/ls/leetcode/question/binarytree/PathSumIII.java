package com.ls.leetcode.question.binarytree;

/**
 * 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * @link https://leetcode-cn.com/problems/path-sum-iii
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return calPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int calPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int tmp = 0;
        sum -= root.val;
        if (sum == 0) {
            tmp++;
        }
        return tmp + calPathSum(root.left, sum) + calPathSum(root.right, sum);
    }
}
