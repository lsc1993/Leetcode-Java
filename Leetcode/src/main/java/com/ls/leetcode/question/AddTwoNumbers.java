package com.ls.leetcode.question;

import com.ls.leetcode.util.Log;

/**
 * Add Two Numbers
 *
 * describe:
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * simple:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author liushuang
 */
public class AddTwoNumbers {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }

        ListNode newNode = null;
        ListNode head = null;
        int temp, addNum = 0;

        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + addNum;
            if (newNode == null) {
                if (temp >= 10) {
                    newNode = new ListNode(temp - 10);
                    addNum = 1;
                } else {
                    newNode = new ListNode(temp);
                    addNum = 0;
                }
                head = newNode;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                if (temp >= 10) {
                    newNode.next = new ListNode(temp - 10);
                    addNum = 1;
                } else {
                    newNode.next = new ListNode(temp);
                    addNum = 0;
                }
                newNode = newNode.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        if (l1 == null && l2 == null && addNum == 1) {
            newNode.next = new ListNode(1);
        }

        ListNode tempNode = null;
        if (l1 == null && l2 != null) {
            tempNode = l2;
        } else if (l1 != null && l2 == null) {
            tempNode = l1;
        }

        while (tempNode != null) {
            int r1 = tempNode.val + addNum;
            if (r1 >= 10) {
                newNode.next = new ListNode(r1 - 10);
                addNum = 1;
            } else {
                newNode.next = new ListNode(r1);
                addNum = 0;
            }

            newNode = newNode.next;
            tempNode = tempNode.next;
        }
        if (addNum == 1) {
            newNode.next = new ListNode(addNum);
        }

        return head;
    }

    /**
     * 存在越界问题
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        long resultL1 = 0L;
        int a = 0;
        while (l1 != null) {
            resultL1 += l1.val * Math.pow(10, a);
            l1 = l1.next;
            ++a;
        }

        long resultL2 = 0L;
        int b = 0;
        while (l2 != null) {
            resultL2 += (long)(l2.val) * Math.pow(10, b);
            l2 = l2.next;
            ++b;
        }

        long result = resultL1 + resultL2;
        String str = String.valueOf(result);
        int len = str.length();
        ListNode headResult;
        ListNode head = new ListNode(Integer.valueOf(String.valueOf(str.charAt(len - 1))));
        headResult = head;
        for (int i = len - 2;i >= 0; i--) {
            head.next = new ListNode(Integer.valueOf(String.valueOf(str.charAt(i))));
            head = head.next;
        }
        return headResult;
    }

    public static void testAddTwoNumbers() {
        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(4);

        ListNode head = addTwoNumbers(l1, l2);
        Log.log("List is:");
        while (head != null) {
            Log.log(String.valueOf(head.val));
            head = head.next;
        }

    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
