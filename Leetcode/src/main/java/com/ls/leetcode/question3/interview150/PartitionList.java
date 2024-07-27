package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.list.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode tmpHead = new ListNode(-1);
        ListNode small = null, big = new ListNode(-1);
        ListNode bigHead = big;
        while (head != null) {
            if (head.val < x) {
                if (small == null) {
                    small = head;
                    tmpHead.next = small;
                } else {
                    small.next = head;
                    small = small.next;
                }
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        if (small != null) {
            small.next = bigHead.next;
        } else {
            tmpHead.next = bigHead.next;
        }
        big.next = null;
        return tmpHead.next;
    }
}
