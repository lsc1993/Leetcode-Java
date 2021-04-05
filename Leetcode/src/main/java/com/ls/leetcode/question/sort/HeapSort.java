package com.ls.leetcode.question.sort;

/**
 * 堆排序
 * describe:
 *     在一个数组中,对于下标为i的节点,
 *     它的左子节点下标是2i + 1,右子节点下标是2i,父节点下标是i/2
 *
 *     维护最大(小)堆性质:
 *         做子节点与右子节点比较,最大(小)的与父节点比较,然后交换
 *
 *     堆排序过程:
 *         (1) 创建最大(小)堆
 *            在数组中,n/2 down to 1都是子树的父节点,
 *            通过最大(小)堆的特点循环或者递归(@see 维护堆性质)可以获得最大(小堆)
 *         (2) 堆排序
 *            n down to 1,交换a[0] a[n]将最大(小)值移到最后的位置
 *
 * @author liushuanggo@gmail.com
 */
public class HeapSort {

    public static void main(String[] args) {
        int array[] = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        heapSort(array);

        for (int value : array) {
            System.out.print(value + "->");
        }
    }

    /**
     * 堆排序
     *
     * @param array 需要排序的数组
     */
    static void heapSort(int[] array) {
        //buildMaxHeap(array);

        int len = array.length;
        /*for (int i = len - 1; i >= 0; --i) {
            swap(array, 0, i);
            maxHeapfyLoop(array, 0, i);
        }*/

        System.out.println();
        buildMaxHeapRecursion(array);

        for (int i = len - 1; i >= 0; --i) {
            swap(array, 0, i);
            maxHeapfyRecursion(array, 0, i);
        }
    }

    /**
     * 维护最大(小)堆的性质,保证堆一直处于最大(小)堆状态
     *
     * @param a 需要比较的数组
     * @param index 父节点下标
     * @param len 数组长度
     */
    static void maxHeapfyLoop(int a[], int index, int len) {
        int childIndex = 0;
        int tmp;
        for (tmp = a[index]; leftChild(index) < len; index = childIndex) {
            childIndex = leftChild(index); //1.获取做子节点下标
            //2.比较左子节点与右子节点的大小,取最大(小)值,这里是最大堆排序
            if (childIndex != (len -1) && a[childIndex] < a[childIndex + 1]) {
                childIndex ++;
            }
            //3.与父结点比较
            if (tmp < a[childIndex]) {
                a[index] = a[childIndex];
            } else {
                /*
                 * 这里是一个优化的步骤,如果父节点不小于子节点,
                 * 在自底向上的情况下,父节点必然也大于其他子节点
                 */
                break;
            }
        }
        a[index] = tmp;
    }

    /**
     * 创建最大堆,自底向上创建
     *
     * @param a 数组
     */
    static void buildMaxHeap(int a[]) {
        int len = a.length;
        for (int i = len / 2 -1; i>=0; --i) {
            maxHeapfyLoop(a, i, len);
        }
    }

    static void maxHeapfyRecursion(int[] array, int index, int len) {
        int childIndex = leftChild(index);
        if (childIndex < len) {
            int tmp = array[index];
            if (childIndex != len - 1 && array[childIndex] < array[childIndex + 1]) {
                childIndex ++;
            }
            if (tmp < array[childIndex]) {
                swap(array, index, childIndex);
                maxHeapfyRecursion(array, childIndex, len);
            }
        }
    }

    static void buildMaxHeapRecursion(int a[]) {
        int len = a.length;
        for (int i = len / 2 -1; i>=0; --i) {
            maxHeapfyRecursion(a, i, len);
        }
    }

    static int leftChild(int index) {
        return 2 * index + 1;
    }

    static void swap(int a[], int i, int ii) {
        int tmp = a[i];
        a[i] = a[ii];
        a[ii] = tmp;
    }
}
