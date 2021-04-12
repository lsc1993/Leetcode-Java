package com.ls.leetcode.question.doubleponiter;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * describe:
 *     输入一个整数数组,实现一个函数来调整该数组中数字的顺序,
 *     使得所有奇数位于数组的前半部分,偶数位于后半部分.
 *
 * @author liushuanggo@gmail.com
 * date: 2019-8-5
 */
public class OddPreviousEven {

    public static void main(String[] args) {
        int[] array = {4, 3, 12, 1, 5, 8, 6, 7, 10};

        makeOddPreEven2(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    static void makeOddPreEven(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int oddIndex = 0;
        int evenIndex = 0;
        int index = 0;
        boolean hasSmallestEven = false;
        while (index < array.length) {
            if (array[index] % 2 == 0) {
                if (!hasSmallestEven) {
                    evenIndex = index;
                    hasSmallestEven = true;
                }
            } else {
                oddIndex = index;
            }

            index ++;

            if (evenIndex < oddIndex) {
                int tmp = array[evenIndex];
                array[evenIndex] = array[oddIndex];
                array[oddIndex] = tmp;

                evenIndex ++;
                oddIndex = evenIndex;
            }
        }
    }

    static void makeOddPreEven2(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int oddIndex = array.length - 1;
        int evenIndex = 0;
        while (evenIndex < oddIndex) {
            //偶数
            while ((array[evenIndex] & 0x1) != 0) {
                evenIndex ++;
            }

            while ((array[oddIndex] & 0x1) == 0) {
                oddIndex --;
            }

            if (evenIndex < oddIndex) {
                int tmp = array[oddIndex];
                array[oddIndex] = array[evenIndex];
                array[evenIndex] = tmp;
            }
        }
    }
}
