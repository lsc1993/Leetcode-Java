package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.list.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
