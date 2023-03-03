package com.ls.leetcode.questionv2.list;

import com.ls.leetcode.question.list.ListNode;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-03
 */
public class ReversePrintList {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> nodeList = new Stack<>();
        while (head != null) {
            nodeList.add(head.val);
            head = head.next;
        }
        int size = nodeList.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = nodeList.pop();
        }
        return result;
    }
}
