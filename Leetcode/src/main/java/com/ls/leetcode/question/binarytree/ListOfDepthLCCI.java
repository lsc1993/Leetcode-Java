package com.ls.leetcode.question.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，
 * 创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 *
 * @link https://leetcode-cn.com/problems/list-of-depth-lcci/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-5
 */
public class ListOfDepthLCCI {

    /**
     * 通过广度优先遍历获取所有层级的节点
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = null;
            ListNode listNode;
            ListNode next = null;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node != null) {
                    listNode = new ListNode(node.val);
                    if (next != null) {
                        next.next = listNode;
                    }
                    next = listNode;
                    if (i == 0) {
                        head = listNode;
                    }

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            if (head != null) {
                listNodes.add(head);
            }
        }
        return listNodes.toArray(ListNode[]::new);
    }
}
