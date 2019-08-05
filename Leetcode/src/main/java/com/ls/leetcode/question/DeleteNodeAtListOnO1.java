package com.ls.leetcode.question;

/**
 * 在O(1)时间删除链表节点
 *
 * describe:
 *     给定单向链表头指针和一个结点指针,
 *     定义一个函数在O(1)时间内删除该结点.
 *
 * @author liushuanggo@gmail.com
 */
public class DeleteNodeAtListOnO1 {

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(4);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(7);

        ListNode head = delNodeAtO1(list, list.next.next.next);

        while (head != null) {
            System.out.println(head.val == -1? "" : head.val + " ");
            head = head.next;
        }

    }

    static ListNode delNodeAtO1(ListNode head, ListNode nodeToDelete) {
        if (head == null || nodeToDelete == null) {
            return head;
        }
        if (nodeToDelete.next == null) {
            nodeToDelete.val = -1;
        } else if (head.next == null && head == nodeToDelete) {
            head = null;
        } else {
            nodeToDelete.val = nodeToDelete.next.val;
            nodeToDelete.next = nodeToDelete.next.next;
        }

        return head;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
