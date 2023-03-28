package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.list.ListNode;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-28
 */
public class TwoListCommonNode {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
            if (tmpA == null && tmpB == null) {
                return null;
            }
            if (tmpA == null) {
                tmpA = headB;
            }

            if (tmpB == null) {
                tmpB = headA;
            }
        }

        return tmpA;
    }
}
