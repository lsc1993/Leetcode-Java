package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.list.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode tmpHead = head;
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        ListNode tmp = null;
        int start = 1;
        while (head != null) {
            ListNode node = head;
            if (start >= left && start <= right) {
                tmpHead = head.next;
                node.next = tmp;
                tmp = node;
                head = tmpHead;
                newTail.next = tmp;
            } else {
                if (right < start) {
                    while (newTail.next != null) {
                        newTail = newTail.next;
                    }
                    newTail.next = head;
                    break;
                }
                newTail.next = head;
                head = head.next;
                newTail = newTail.next;
            }
            start++;
        }
        return newHead.next;
    }
}
