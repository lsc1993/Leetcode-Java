package com.ls.leetcode.question;

/**
 * 链表中倒数第K个结点
 *
 * describe:
 *     输入一个链表,输出该链表中倒数第K个结点.
 *
 * @author liushuanggo@gmail.com
 */
public class ListLatButKNode {

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(4);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(7);
        list.next.next.next.next = new ListNode(8);
        list.next.next.next.next.next = new ListNode(9);
        ListNode node = lastButKNode2(list, 4);
        if (node != null) {
            System.out.println("lat but k node is : " + node.val);
        } else {
            System.out.println("lat but k node is null");
        }
    }

    static ListNode lastButKNode(ListNode node, int k) {
        if (k == 0 || node == null) {
            return null;
        }
        int numberOfList = 0;
        ListNode pHead = node;
        ListNode pBehind = node;
        while (pHead != null) {
            pHead = pHead.next;
            numberOfList ++;
            if (numberOfList >= k) {
                pBehind = pBehind.next;
            }
        }

        if (numberOfList < k) {
            return null;
        }
        return pBehind;
    }

    static ListNode lastButKNode2(ListNode node, int k) {
        if (k == 0 || node == null) {
            return null;
        }

        ListNode pHead = node;
        ListNode pBehind = node;
        for (int i = 0;i < k - 1; ++i) {
            if (pHead.next != null) {
                pHead = pHead.next;
            } else {
                return null;
            }
        }

        while (pHead != null) {
            pHead = pHead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
