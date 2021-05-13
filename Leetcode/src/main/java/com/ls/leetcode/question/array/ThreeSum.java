package com.ls.leetcode.question.array;

import java.util.*;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * {}@link https://leetcode-cn.com/problems/3sum
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-13
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> res = twoSum(nums, i + 1, - nums[i]);
            for (List<Integer> list : res) {
                list.add(nums[i]);
                resultList.add(list);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }

        return resultList;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> res;
        int end = nums.length - 1;
        while (start < end) {
            int left = nums[start];
            int right = nums[end];
            int sum = left + right;
            if (sum == target) {
                res = new ArrayList<>();
                res.add(nums[start]);
                res.add(nums[end]);
                resultList.add(res);

                while (start < end && nums[start] == left) start ++;
                while (start < end && nums[end] == right) end --;
            } else if (sum < target) {
                start ++;
            } else {
                end --;
            }
        }

        return resultList;
    }
}
