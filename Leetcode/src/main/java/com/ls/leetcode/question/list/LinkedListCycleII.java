package com.ls.leetcode.question.list;

/**
 * 环形链表 II

 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * {}@link https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-16
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        return slow;
    }
}
