package com.ls.leetcode.question.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-18
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
