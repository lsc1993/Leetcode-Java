package com.ls.leetcode.question.list;

import com.ls.leetcode.question.binarytree.ListNode;

public class MergeList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(6);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(8);

        ListNode head = merge(node1, node2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode merge(ListNode root1, ListNode root2) {
        ListNode head = new ListNode(1);
        ListNode newHead = head;
        while (root1 != null && root2 != null) {
            if (root1.val > root2.val) {
                head.next = root2;
                root2 = root2.next;
            } else {
                head.next = root1;
                root1 = root1.next;
            }
            head = head.next;
        }
        if (root1 == null) {
            while (root2 != null) {
                head.next = root2;
                root2 = root2.next;
                head = head.next;
            }
        } else {
            while (root1 != null) {
                head.next = root1;
                root1 = root1.next;
                head = head.next;
            }
        }
        return newHead.next;
    }
}
