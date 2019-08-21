package com.ls.leetcode.question;

/**
 * 最大的K个数
 *
 * describe:
 *     输入n个整数,找出其中最大的K个数
 *
 * @author liushuanggo@gmail.com
 * data: 2019-8-21
 */
public class TopK {

    public static void main(String[] args) {
        int array[] = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        //topKProblem(array, 5);
        //topK(array, 3);

        topKPartition(array, 4);
    }

    /**
     * 使用排序算法获得最大的K个数
     */
    static void topKProblem(int[] array, int k) {
        if (k <= 0) {
             return;
        }

        HeapSort.buildMaxHeap(array);
        for (int i = 0; i < k; ++ i) {
            swap(array, 0, array.length - 1 - i);
            HeapSort.maxHeapfyLoop(array, 0, array.length - 1 - i);
        }

        for (int i = array.length - 1; i >= array.length - k; -- i) {
            System.out.print(array[i] + " -> ");
        }
    }

    static void swap(int a[], int i, int ii) {
        int tmp = a[i];
        a[i] = a[ii];
        a[ii] = tmp;
    }

    /**
     * 结合堆的数据结构,构造一个含有K个数的堆
     * 使用最大堆获得最小的K个数,使用最小堆获得最大的几个数
     */
    static void topK(int[] array, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; ++ i) {
            heap[i] = array[i];
        }

        HeapSort.buildMaxHeap(heap);

        for (int i = k; i < array.length; ++ i) {
            if (heap[0] > array[i]) {
                heap[0] = array[i];
                HeapSort.buildMaxHeap(heap);
            }
        }

        for (int i = 0;i < k; ++ i) {
            System.out.print(heap[i] + " -> ");
        }
    }

    /**
     * 基于Partition的方法解决TopK问题
     */
    static void topKPartition(int[] array, int k) {
        if (k < 0 || k >= array.length) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        int index = QuickSort.partition(array, array.length, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                QuickSort.partition(array, array.length, start ,end);
            } else {
                start = index + 1;
                QuickSort.partition(array, array.length, start, end);
            }
        }

        for (int i = 0; i < k; ++ i) {
            System.out.print(array[i] + " -> ");
        }
    }
}
