package com.ls.leetcode.question.binarytree;

import java.util.*;

/**
 * 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * @link https://leetcode-cn.com/problems/path-sum-ii
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class PathSumII {

    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum2(root, targetSum);

        return lists;
    }

    /**
     * 深度优先遍历
     */
    public void pathSum2(TreeNode root, int targetSum) {
        if (root != null) {
            path.offerLast(root.val);
            if (root.left == null && root.right == null) {
                if (targetSum == root.val) {
                    lists.add(new LinkedList<>(path));
                }
            }

            pathSum2(root.left, targetSum - root.val);
            pathSum2(root.right, targetSum - root.val);

            path.pollLast();
        }
    }
}
