package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.list.ListNode;

/**
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-18
 */
public class ListKthNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = k;
        ListNode tmp = head;
        while (n > 0) {
            n--;
            tmp = tmp.next;
        }
        while (tmp != null) {
            head = head.next;
            tmp = tmp.next;
        }

        return head;
    }
}
