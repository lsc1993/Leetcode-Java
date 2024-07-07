package com.ls.leetcode.question3.interview150;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        // h 指数 满足 至少有h篇论文(条件1)   被引用次数大于等于h (条件2)
        // 因为倒序遍历和 h = 0且是h++的逻辑，所以永远满足条件1
        for (int i = citations.length - 1; i >= 0; i--) {
            // 如果当前文献引用次数>h 满足了条件2
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
}
