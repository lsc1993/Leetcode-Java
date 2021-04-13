package com.ls.leetcode.question.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * {}@link https://leetcode-cn.com/problems/combination-sum
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-14
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int[] arr = new int[] {2, 3, 6, 7};
        int target = 7;
        sum.combinationSum(arr, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        calResult(candidates, resultList, list, target, 0);
        return resultList;
    }

    public void calResult(int[] candidates, List<List<Integer>> resultList, List<Integer> list, int target, int begin) {
        int sum = sum(list);
        if (sum == target) {
            resultList.add(new ArrayList<>(list));
        } else {
            for (int i = begin; i < candidates.length; ++i) {
                list.add(candidates[i]);
                if (sum(list) <= target) {
                    calResult(candidates, resultList, list, target, i);
                    list.remove(list.size() - 1);
                } else {
                    list.remove(list.size() - 1);
                    break;
                }
            }
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int val : list) {
            sum += val;
        }
        return sum;
    }
}
