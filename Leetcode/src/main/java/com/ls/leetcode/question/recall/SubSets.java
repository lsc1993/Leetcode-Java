package com.ls.leetcode.question.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * {}@link https://leetcode-cn.com/problems/subsets/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-14
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return resultList;
        }
        Arrays.sort(nums);
        resultList.add(new ArrayList<>());
        for (int i= 0; i < nums.length; ++i) {
            // 选择列表是： 选 1...n 个
            getSubSets(resultList, new ArrayList<>(), nums, i + 1);
        }
        return resultList;
    }

    private void getSubSets(List<List<Integer>> resultList, List<Integer> list, int[] nums, int size) {
        if (list.size() == size) {
            resultList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (list.contains(nums[i])) {
                    continue;
                }

                if (list.size() > 0 && list.get(list.size() - 1) > nums[i]) {
                    continue;
                }

                list.add(nums[i]);
                getSubSets(resultList, list, nums, size);
                list.remove(list.size() - 1);
            }
        }
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     * 递归方式
     * 每个元素有两种状态，选 或者 不选
     * 0 到 cur-1 的位置代表已经选择过的
     * cur + 1 到 n 的位置代表没有选择过的
     */
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]); // 选择当前元素
        dfs(cur + 1, nums); // 计算cur + 1 到 n 的结果
        t.remove(t.size() - 1); // 不选择当前元素， 回溯
        dfs(cur + 1, nums); // 计算cur + 1 到 n 的结果
    }
}
