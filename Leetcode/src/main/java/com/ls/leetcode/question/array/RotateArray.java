package com.ls.leetcode.question.array;

/**
 * 旋转数组
 *
 * describe:
 * 把一个有序数组的若干个元素搬到末尾，成为旋转数组，求旋转数组中的最小值
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 3, 3};
        int[] array1 = {1, 1, 1, 0, 1};

        System.out.print(findSmallest(array1) + "");
    }

    static int findSmallest(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int middle = start;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                middle = end;
                break;
            }

            middle = (start + end) / 2;

            System.out.println(String.valueOf(middle));

            if (array[middle] > array[start]) {
                start = middle;
            } else if (array[middle] == array[start] && array[middle] == array[end]) {
                for (int i = 0; i < array.length - 1; ++ i) {
                    if (array[i] > array[i+1]) {
                        return array[i + 1];
                    }
                }
            } else {
                end = middle;
            }
        }

        return array[middle];
    }
}
