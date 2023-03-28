package com.ls.leetcode.questionv2.array;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author liushuanggo
 * @since 2023-03-28
 */
public class ExchangeOdd {

    public int[] exchange(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[start] % 2 == 0) {
                while (nums[end] % 2 == 0 && end > start) {
                    end --;
                }
                if (end > start) {
                    int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;
                    start ++;
                    end --;
                }
            } else {
                start ++;
            }
        }

        return nums;
    }
}
