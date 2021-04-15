package com.ls.leetcode.question.recall;

import java.util.*;

/**
 * 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明:
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * {}@link https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-15
 */
public class CombinationSumII {

    private List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1) {
            return resultList;
        }

        Arrays.sort(candidates);

        combination(new ArrayDeque<>(), candidates, target, 0);
        return resultList;
    }

    private void combination(Deque<Integer> list, int[] candidates, int target, int begin) {
        if (0 == target) {
            resultList.add(new ArrayList<>(list));
        } else {
            for (int i = begin; i < candidates.length; ++i) {
                if (target - candidates[i] < 0) {
                    break;
                }

                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.addLast(candidates[i]);
                combination(list, candidates, target - candidates[i], i + 1);
                list.removeLast();
            }
        }
    }
}
