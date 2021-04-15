package com.ls.leetcode.question.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * {}@link https://leetcode-cn.com/problems/combinations/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-14
 */
public class Combinations {

    private List<List<Integer>> resultList = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combination(n, k, 1);

        return resultList;
    }

    private void combination(int n, int k, int start) {
        if (list.size() + (n - start + 1) < k) {
            return;
        }

        if (list.size() == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        list.add(start);
        combination(n, k, start + 1);
        list.remove(list.size() - 1);
        combination(n, k, start + 1);
    }
}
