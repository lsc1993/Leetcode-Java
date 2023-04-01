package com.ls.leetcode.questionv2.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * https://leetcode.cn/problems/majority-element
 *
 * @author liushuanggo
 * @since 2023-04-02
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        int value = 0;
        Set<Integer> set = map.keySet();
        for (int n : set) {
            int v = map.get(n);
            if (v > max) {
                max = v;
                value = n;
            }
        }
        return value;
    }
}
