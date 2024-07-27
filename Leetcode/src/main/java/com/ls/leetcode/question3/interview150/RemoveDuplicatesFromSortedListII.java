package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.list.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmpHead = new ListNode(-1, head);
        ListNode tmp = tmpHead;
        while (head != null) {
            if (head.next != null) {
                if (head.val == head.next.val) {
                    while (head.next != null && head.val == head.next.val) {
                        head.next = head.next.next;
                    }
                    tmp.next = head.next;
                } else {
                    tmp.next = head;
                    tmp = tmp.next;
                }
            }
            head = head.next;
        }
        return tmpHead.next;
    }
}
