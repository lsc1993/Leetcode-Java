package com.ls.leetcode.question.dp;

import java.util.Arrays;

/**
 * 最接近目标价格的甜点成本
 *
 * 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 *
 * 必须选择 一种 冰激凌基料。
 * 可以添加 一种或多种 配料，也可以不添加任何配料。
 * 每种类型的配料 最多两份 。
 * 给你以下三个输入：
 *
 * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 * target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 *
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 *
 * https://leetcode.cn/problems/closest-dessert-cost
 *
 * @author liushuanggo
 * @since 2022-12-5
 */
public class ClosestDessertCost {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 冰淇淋基料的最小值min，
        int min = Arrays.stream(baseCosts).min().getAsInt();
        // 其他任何方案成本只会比min更大，与target的插值更大，此时直接返回min
        if (min >= target) {
            return min;
        }
        // 对称性。
        // 三个数字分别为min target upper（等差数组），当接近程度相同时选择价格小的。
        // 合法的方案下，左端距离target最远的数字就是min（只选价格最低的基料），
        // 相应地，右边最远的值如果称为upper，那么upper - target = target - min，
        // 也就是upper = 2 * target - min，如果超过这个值，此时选择min是最优方案，
        // 因此边界外的就不考虑了。
        // 只需要考虑成本在 [min, upper-1] 间的方案是否存在
        int upper = 2 * target - min;
        boolean[] dp = new boolean[upper];
        // base，基料必选
        for (int baseCost : baseCosts) {
            // 不考虑区间外的方案
            if (baseCost < upper) {
                dp[baseCost] = true;
            }
        }
        // dp迭代，在基料的基础上选择辅料
        for (int toppingCost : toppingCosts) {
            // 倒序遍历dp
            for (int j = upper - 1; j >= min; --j) {
                // 每种辅料可以1份或两份，更新对应的dp为true，区间外不予考虑
                if (dp[j] && (j + toppingCost < upper)) {
                    dp[j + toppingCost] = true;
                }
                if (dp[j] && (j + 2 * toppingCost < upper)) {
                    dp[j + 2 * toppingCost] = true;
                }
            }
        }
        // 在 [min, upper-1]所有存在的方案种找出与target最接近的方案
        int ans = min;
        for (int i = min + 1; i < upper; ++i) {
            if (dp[i]) {
                // 更接近
                if (Math.abs(i - target) < Math.abs(ans - target)) {
                    ans = i;
                    // 同样接近，选择更小成本
                } else if (Math.abs(i - target) == Math.abs(ans - target)) {
                    ans = Math.min(ans, i);
                }
            }
        }
        return ans;
    }
}
