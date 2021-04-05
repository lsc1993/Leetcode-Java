package com.ls.leetcode.question.binarytree;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @link https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-5
 */
public class ConvertSortArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = transform(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode transform(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = transform(nums, start, mid - 1);
        root.right = transform(nums, mid + 1, end);
        return root;
    }
}
