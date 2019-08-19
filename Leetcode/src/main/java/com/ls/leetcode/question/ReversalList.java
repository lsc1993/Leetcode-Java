package com.ls.leetcode.question;

/**
 * 反转链表
 * <p>
 * describe:
 * 输入一个链表的头结点,反转该链表并输出反转后链表的头结点
 *
 * @author liushuanggo@gmail.com
 * date : 2019-8-12
 */
public class ReversalList {

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(4);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(7);
        list.next.next.next.next = new ListNode(8);
        list.next.next.next.next.next = new ListNode(9);

        ListNode rHead = reversalList(list);

        while (rHead != null) {
            System.out.print(rHead.val + " -> ");
            rHead = rHead.next;
        }
    }

    static ListNode reversalList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversalHead = null;
        ListNode tmpHead = head;
        ListNode pPrev = null;

        while (tmpHead != null) {
            ListNode node = tmpHead.next;
            if (node == null) {
                reversalHead = tmpHead;
            }

            tmpHead.next = pPrev;
            pPrev = tmpHead;
            tmpHead = node;
        }

        return reversalHead;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
