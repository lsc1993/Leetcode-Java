package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.list.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode iter = head;
        int n = 1;
        while (iter.next != null) {
            n++;
            iter = iter.next;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add > 0) {
            iter = iter.next;
            add --;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
