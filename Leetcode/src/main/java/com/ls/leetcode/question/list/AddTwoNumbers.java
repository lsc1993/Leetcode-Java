package com.ls.leetcode.question.list;

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
 * @see {linktourl https://leetcode-cn.com/problems/add-two-numbers/description/}
 *
 * @author liushuang
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return result.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
