package com.ls.leetcode.questionv2.array;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * https://leetcode.cn/problems/move-zeroes/
 *
 * @author liushuanggo
 * @since 2023-03-12
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                if (index != i) {
                    int tmp = nums[i];
                    nums[index] = tmp;
                    nums[i] = 0;
                }
                index ++;
            }
        }
    }
}
