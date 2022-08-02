package com.ls.leetcode.question.design;

import com.ls.leetcode.question.list.ListNode;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，
 * 其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * <a href="https://leetcode.cn/problems/design-circular-queue">设计循环队列</a>
 *
 * @author liushuanggo
 * @since 2022-08-02
 */
public class MyCircularQueue {

    private ListNode head;
    private ListNode tail;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size ++;
        return true;
    }

    public boolean deQueue() {
        if (size <= 0) {
            return false;
        }
        size --;
        head = head.next;
        return true;
    }

    public int Front() {
        if (!isEmpty()) {
            return head.val;
        }
        return -1;
    }

    public int Rear() {
        if (!isEmpty()) {
            return tail.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
