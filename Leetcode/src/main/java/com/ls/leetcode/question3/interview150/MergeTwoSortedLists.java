package com.ls.leetcode.question3.interview150;

import com.ls.leetcode.question.list.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, tail = null;

        while (list1 != null || list2 != null) {
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            int result = 0;
            if (val1 > val2) {
                result = val2;
                list2 = list2.next;
            } else {
                result = val1;
                if (list1 != null) {
                    list1 = list1.next;
                }
            }
            if (head == null) {
                head = tail = new ListNode(result, null);
            } else {
                tail.next = new ListNode(result, null);
                tail = tail.next;
            }
        }
        return head;
    }
}
