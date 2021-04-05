package com.ls.leetcode.question.list;

/**
 * 相交链表
 * describe：
 *   编写一个程序，找到两个单链表相交的起始节点。
 *
 *   link: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author liushuanggo@gamil.com
 * @since 2021-01-05
 */
public class IntersectList {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
