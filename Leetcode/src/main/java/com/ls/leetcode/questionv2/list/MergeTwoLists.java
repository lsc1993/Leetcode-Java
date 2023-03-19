package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.list.ListNode;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-19
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null), tmp;
        tmp = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    tmp.next = l2;
                    l2 = l2.next;
                } else {
                    tmp.next = l1;
                    l1 = l1.next;
                }
                tmp = tmp.next;
            }
            if (l1 != null && l2 == null) {
                while (l1 != null) {
                    tmp.next = l1;
                    l1 = l1.next;
                    tmp = tmp.next;
                }
            }
            if (l2 != null && l1 == null) {
                while (l2 != null) {
                    tmp.next = l2;
                    l2 = l2.next;
                    tmp = tmp.next;
                }
            }
        }
        return head.next;
    }
}
