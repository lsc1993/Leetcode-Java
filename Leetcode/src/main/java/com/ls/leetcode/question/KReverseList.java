package com.ls.leetcode.question;

/**
 * K 个一组翻转链表
 * describe:
 *    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *    k 是一个正整数，它的值小于或等于链表的长度。
 *    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *    link：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author liushuanggo@gmail.com
 * @since 2021-01-04
 */
public class KReverseList {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                // 遍历到当前组的k个节点
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            // 翻转k个节点 此时返回的数组中,0是翻转列表的头节点,1是尾节点
            ListNode[] reverse = myReverse(head, tail);
            // 这里head和tail交换了位置,相当于翻转后交换到正常位置
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head; // pre是翻转前head的前一个节点
            tail.next = nex; // tail是翻转后的尾节点,接链表中的下一个节点
            pre = tail; // pre到达tail的位置
            head = tail.next; // head到达新的k个链表的位置
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next; // 下一个需要K翻转的头结点
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next; // 记录需要翻转节点的下个节点位置
            p.next = prev; // 实现翻转,将前一个节点变为next节点
            prev = p; // 实现翻转,形成新的翻转列表
            p = nex; // 链接到下一个需要翻转的节点
        }
        return new ListNode[]{tail, head};
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
