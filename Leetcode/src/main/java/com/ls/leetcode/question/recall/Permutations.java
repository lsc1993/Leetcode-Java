package com.ls.leetcode.question.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * {}@link https://leetcode-cn.com/problems/permutations/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-14
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return resultList;
        }
        permutation(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private void permutation(List<List<Integer>> resultList, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                permutation(resultList, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
