package com.ls.leetcode.question;

/**
 * 合并两个排序的链表
 *
 * describe:
 *     输入两个递增排序的链表,合并两个链表并且使新链表中的结点仍然按照递增排序
 *
 * @author liushuanggo@gmail.com
 * date : 2019-8-13
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(7);
        list1.next.next = new ListNode(8);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(9);

        ListNode list = mergeTwoList(list1, list2);

        while (list != null) {
            System.out.print(list.val + " -> ");
            list = list.next;
        }
    }

    static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode list = null;
        if (list1.val < list2.val) {
            list = list1;
            list.next = mergeTwoList(list1.next, list2);
        } else {
            list = list2;
            list.next = mergeTwoList(list1, list2.next);
        }

        return list;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
