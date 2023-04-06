package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.binarytree.ListNode;

/**
 * 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 *
 * @author liushuanggo
 * @since 2023-04-06
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next== null) {
            return head;
        }
        ListNode newHead = new ListNode(1);
        ListNode head2 = newHead;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode first = tmp.next;
            ListNode second = tmp;
            if (first != null) {
                second.next = first.next;
                first.next = second;
                newHead.next = first;
            }
            newHead = second;
            tmp = second.next;
        }

        return head2.next;
    }
}
