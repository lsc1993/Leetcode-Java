package com.ls.leetcode.question.math;

/**
 * 二进制中1的个数
 *
 * describe:
 *     输入一个整数，输出该数二进制表示中1的个数
 *
 * @author liushuanggo@gmail.com
 */
public class BinaryNumberOfOne {

    public static void main(String[] args) {
        System.out.println(binaryNumberOfOne(9));
        System.out.println(binaryNumberOfOne(1));
        System.out.println(binaryNumberOfOne(10));
        System.out.println(binaryNumberOfOne(8));
        System.out.println(binaryNumberOfOne(16));
    }

    static int binaryNumberOfOne(int num) {
        if (num == 0) {
            return 0;
        }
        int number = 0;
        //在num是负数的时候会造成死循环
        /*while (num != 0) {
            if ((num & 1) == 1) {
                number ++;
            }
            num = num >> 1;
        }*/

        /*int flag = 1;
        while (flag > 0) {
            //32位整数需要循环32次
            if ((num & flag) > 0) {
                number ++;
            }

            flag = flag << 1;
        }*/

        /*
         * 把一个整数减去1后，最右边的1的后面几位都会变成0 ,
         * 而原有的1变成0,
         * 依次类推,有多少次num & (num - 1) 就有几位1
         */
        while (num > 0) {
            ++ number;
            num = num & (num - 1);
        }
        return number;
    }
}
