package com.ls.leetcode.question.list;

/**
 * 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-18
 */
public class KthNodeFromEndOfLcci {

    public int kthToLast(ListNode head, int k) {
        if (k == 0 || head == null) {
            return 0;
        }

        ListNode pHead = head; //头指针,记录走的位置
        ListNode pBehind = head;//后指针,记录倒数K的位置
        //1.先走K步
        for (int i = 0; i < k; ++i) {
            pHead = pHead.next;
            if (pHead == null && i == k - 1) {
                return head.val;
            }
            if (pHead == null && i < k - 1) {
                return 0;
            }
        }

        //2.再走n-k步,得到倒数第K的结点
        while (pHead != null) {
            pHead = pHead.next;
            pBehind = pBehind.next;
        }

        return pBehind.val;
    }
}
