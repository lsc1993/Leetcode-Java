package com.ls.leetcode.questionv2.binarytree;

import com.ls.leetcode.question.binarytree.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-06
 */
public class PrintBinaryTree {

    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeList.poll();
                if (node != null) {
                    result.add(node.val);
                    nodeList.add(node.left);
                    nodeList.add(node.right);
                }
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
