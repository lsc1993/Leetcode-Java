package com.ls.leetcode.question.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * @author liushuanggo
 * @since 2022-07-16
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            List<List<Integer>> threeList = threeSum(nums, i + 1,target - nums[i]);
            for (List<Integer> tList : threeList) {
                tList.add(nums[i]);
                list.add(tList);
            }
            while (i < size - 1 && nums[i] == nums[i + 1]) i ++;
        }
        return list;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, long target) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = start; i < nums.length; ++i) {
            List<List<Integer>> res = twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> list : res) {
                list.add(nums[i]);
                resultList.add(list);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }

        return resultList;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, long target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> res;
        int end = nums.length - 1;
        while (start < end) {
            int left = nums[start];
            int right = nums[end];
            long sum = (long) left + right;
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

    public List<List<Integer>> otherSolution(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
