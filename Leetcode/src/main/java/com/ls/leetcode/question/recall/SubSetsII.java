package com.ls.leetcode.question.recall;

import java.util.*;

/**
 * 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * {}@link https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-20
 */
public class SubSetsII {

    private List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 1) {
            return resultList;
        }

        Arrays.sort(nums);
        boolean[] visits = new boolean[nums.length];
        dfs(nums, new ArrayDeque<>(), visits);

        return resultList;
    }

    private void dfs(int[] nums, Deque<Integer> list, boolean[] visits) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (visits[i] || (i > 0 && nums[i] == nums[i - 1] && !visits[i - 1])) {
                continue;
            }
            list.addLast(nums[i]);
            visits[i] = true;
            dfs(nums, list, visits);
            list.removeLast();
            visits[i] = false;
        }
    }
}
