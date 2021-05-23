package com.ls.leetcode.question.list;

/**
 * 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-23
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int first = n;
        while (first -- > 0) {
            tmp = tmp.next;
            if (tmp == null) {
                return null;
            }
        }
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy;
        while (tmp != null) {
            tmp = tmp.next;
            node = node.next;
        }

        node.next = node.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
