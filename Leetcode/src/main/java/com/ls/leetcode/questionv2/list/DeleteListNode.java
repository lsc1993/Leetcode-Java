package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.list.ListNode;

/**
 * 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-18
 */
public class DeleteListNode {

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}
