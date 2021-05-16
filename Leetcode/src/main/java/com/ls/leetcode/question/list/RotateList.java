package com.ls.leetcode.question.list;

/**
 * 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * {}@link https://leetcode-cn.com/problems/rotate-list/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-16
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 1) {
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len ++;
            tmp = tmp.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        int jump = len - k - 1;
        ListNode node = head;
        while (jump > 0) {
            jump --;
            node = node.next;
        }
        ListNode newHead = node.next;
        ListNode tmpHead = node.next;
        if (newHead == null) {
            return node;
        }
        node.next = null;
        while (tmpHead.next != null) {
            tmpHead = tmpHead.next;
        }

        tmpHead.next = head;

        return newHead;
    }
}
