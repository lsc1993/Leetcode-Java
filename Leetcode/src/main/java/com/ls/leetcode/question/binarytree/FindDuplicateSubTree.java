package com.ls.leetcode.question.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * @link https://leetcode-cn.com/problems/find-duplicate-subtrees/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-11
 */
public class FindDuplicateSubTree {

    Map<String, Integer> count = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftI = new TreeNode(4);
        left.left = leftI;
        TreeNode leftII = new TreeNode(2);
        TreeNode rightI = new TreeNode(4);
        right.left = leftII;
        right.right = rightI;
        TreeNode leftIII = new TreeNode(4);
        TreeNode rightII = new TreeNode(5);
        leftII.left = leftIII;
        leftII.right = rightII;

        FindDuplicateSubTree find = new FindDuplicateSubTree();
        find.findDuplicateSubtrees(root);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return ans;
    }

    private String collect(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String serial = root.val + "," + collect(root.left) + "," + collect(root.right);
        System.out.println(serial);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            ans.add(root);
        }
        return serial;
    }
}
