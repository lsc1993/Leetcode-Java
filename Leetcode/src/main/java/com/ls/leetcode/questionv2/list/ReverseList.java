package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.list.ListNode;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-03
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmpHead = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = tmpHead;
            tmpHead = tmp;
        }
        return tmpHead;
    }
}
